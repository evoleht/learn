package com.evoleht.memcache;

/**  
 * ---------------4.15----------------------------
 * memcache是一个键值对存储的hashmap，数据存储在内存中，相对于传统数据库，访问速度会很快，因为传统数据库为了
 * 数据的持久性，会将数据存放在磁盘上，io读写时速度相对慢。
 * memcacahe内存模型：
 * memcache内存模型中有几个概念，slab、chunk、slabclass
 * 
 * memcache会将内存预先分配为几个slabclass，每个slabclass存储的数据大小都是相同的，
 * 相邻slabclass的大小默认是按1.25倍增长。
 * 每个slabclass下是一组slab，memcache又将slab切割成一组chunk，chunk是真正存放数据的地方
 * chunk的大小是按slabclass中的 chunksize 进行分配。
 * 每个slabclass中又维护了一个slots链表来记录空闲chunk，还有个lru链表来跟踪items的使用情况
 * 
 * 当我们set数据时，根据数据的大小，找到相应的slabclass，会访问下lru链表来是否有过期的空间可以使用，使用了个
 * for循环的方式，默认查找5次，看是否能找到合适的空间，如果没有的话，则去slots链表查找是否有空间可以使用，
 * 如果没有剩余空间可以使用，则申请一个新的slab来分配空间，如果空间已经使用完，无法在分配的话，则再去查找lru维护的
 * 链表将最后使用的空间清除。找到空间之后将items存储在这个空间内，同时会将数据维护在一个hashmap中。
 * 
 * 
 * 
 * 
 * 
 * -------------------------------------------
 * memcache 是一个存储键值对的HashMap。
 * memecache 虽然被称为“分布式缓存”，但是它本身完全不具备分布式的功能。memcache集群之间不会相互通信。
 * 所谓的“分布式”完全依赖客户端程序代码实现。
 * memcache的分布式图：memcache-分布式.png
 * 
 * 基于上图，走一次memcache 读写的流程：
 * 1.应用程序输入需要写入的缓存数据
 * 2.API讲key输入路由算法模块，路由算法根据key 和memecahce 集群服务器列表得到一台服务器编号
 * 3.由服务器编号得到memecacheIP地址和端口号
 * 4.API调用通信模块和指定编号的服务器通信，将数据写入该服务器，完成一次分布式缓存写操作。
 * 
 * memcache 原理:
 * memcache 的数据是存放在内存中的，存放在内存中意味着：
 * 1.访问数据的速度比传统的关系型数据库要快，因为oracle、mysql这些传统的关系型数据库为了保持数据的持久性
 * 数据存放在硬盘中，IO操作速度慢
 * 2.memcache 的数据存放在内存中同时意味着只有memcache重启，数据就会消失
 * 3.memcache 的数据存放在内存中，那么势必受到机器位数的限制，32位机器最多只能使用2GB的内存空间，64位机器
 * 上可以任务没有上限
 * 
 *  memcache采用的内存分配方式是固定空间分配。
 *  原理图：memcache-原理.png
 *  图片中涉及了slab——class、slab、page、chunk四个概念
 *  1.memcache将内存空间分为一组slab
 *  2.每个slab下又有若干个page，每个page默认是1M,如果一个slab占用100M内存的话，那个这个slab下应该有100个page
 *  3.每个page里面包含一组chunk，chunk是真正存放数据的地方，同一个slab里面的chunk的大小是固定的
 *  4.有相同大小的chunk的slab被组织在一起，成为slab_class
 * 
 *  memecache 内存分配的方式称为allocator，slab的数量有限，几个，十几个或者几十个，这个和启动参数的配置相关。
 *  
 *  memcache中的value过来存放的地方是由value的大小决定的，value总是被存放到与chunk大小最接近的一个slab中
 *  比如slab[1]的chunk大小为80k、slab[2]的chunk大小为100K、slab[3]的chunk大小为128k（相邻的slab内的chunk基本
 *  以1.25为比例进行增长，memcache启动时可以用-f指定这个比例），那么过来一个88k的value，那么这个value讲被放到
 *  2号slab中。放slab的时候，首选slab要申请内存，申请内存是以page为单位的，所以放第一个数据的时候，无论大小为多少，
 *  都会有1M大小的page被分配给slab。申请到page之后，slab会将这个page的内存按chunk的大小进行切分，这样就变成了一个
 *  chunk数组，最后从这个chunk数组中选择一个用于存储数据。
 *  
 *  如果这个slab中没有chunk可以分配怎么办，如果memcache启动没有追加-M（禁止LRU，这种情况下内存不够回报out of Memory）
 *  那么memchce会把这个slab中最近最少使用的chunk中的数据清理掉，然后放上最新数据。
 *  
 *  memcache内存分配回收算法有三点总结：
 *  1。memcache的内存分配chunk里面会有内存浪费，88字节的value分配在100k的chunk中，浪费了12k，但这也避免了管理
 *  内存碎片的问题。
 *  2.memcache的LRU算法不是针对全局的，是针对slab的
 *  3.应该可以理解为什么memcache存放的value大小是限制的，因为一个新数据过来，slab会以page为单位申请一块内存
 *  申请的内存最多就是1M，所以value大小自然不能大于1M
 *  
 *  
 *  总结memcache的特性和限制
 *  1.memcache中可以存放的item数据量史美仪限制的，只要内存足够
 *  2.memcache单进程在32位机器中最大的内存为2G，64位的没有限制
 *  3.key的最大长度为250k，超过长度无法存储
 *  4.单个item的最大数据是1M，超过1M无法存储
 *  5.memcache服务端是不安全的，比如已知某个cache节点，可以直接telnet过去，并通过flush_all让已经存在的键值对立即失效
 *  6.不能够遍历memcache的所有item，因为这个操作的速度相对缓慢且会阻塞其它操作
 *  7.memcache的高性能源于两个阶段的hash结构：第一阶段在客户端，通过hash算法根据key值算出一个节点
 *  第二阶段在服务端，通过内部的一个hash算法找到真正的item
 *  8.memecache设置添加某一个key值的时候，传入expiry为0表示这个key值永久有效，这个key值也会在30天之后失效
 *  见memcache.c的源代码：
 *  #define REALTIME_MAXDELTA 60*60*24*30
	static rel_time_t realtime(const time_t exptime) {
       if (exptime == 0) return 0;
       if (exptime > REALTIME_MAXDELTA) {                       
              if (exptime <= process_started)                         
                      return (rel_time_t)1;                                 
              return (rel_time_t)(exptime - process_started);  
       } else {                                                                  
              return (rel_time_t)(exptime + current_time);     
       }
	}
	这个失效的时间是memcache源码里面写的，开发者没有办法改变MemCache的Key值失效时间为30天这个限制
 *  
 *  memcache 指令汇总
 *  已知memcache的节点，telnet过去，就可以使用各种命令操作memcache
 *  
 *  get 返回key对应的value值
 *  add 添加一个key值，没有则添加成功并提示stored 有则失败并提示no_stored
 *  set 无条件的设置一个key，没有就增加，有就覆盖，操作成功提示stored
 *  replace 按照相应的key替换数据，如果key值不存在则会操作失败
 *  stats 返回memcache通用统计信息
 *  stats items 返回各个slba中item的数目和最老的item的年龄（最后一次访问距离限制的秒数）
 *  stats slabs 返回memcache运行期间传教的每个slab的信息
 *  version 返回当前memcache的版本号
 *  flush_all 清空所有的键值，但不会删除items，所以memcache依旧占用内存
 *  quit 关闭连接‘
 *  
 *  stats指令解读
 *  stats是一个比较重要的指令，用于列出当前MemCache服务器的状态，拿一组数据举个例子：
 *  
 *  STAT pid 1023
	STAT uptime 21069937
	STAT time 1447235954
	STAT version 1.4.5
	STAT pointer_size 64
	STAT rusage_user 1167.020934
	STAT rusage_system 3346.933170
	STAT curr_connections 29
	STAT total_connections 21
	STAT connection_structures 49
	STAT cmd_get 49
	STAT cmd_set 7458
	STAT cmd_flush 0
	STAT get_hits 7401
	STAT get_misses 57
	..（delete、incr、decr、cas的hits和misses数，cas还多一个badval）
	STAT auth_cmds 0
	STAT auth_errors 0
	STAT bytes_read 22026555
	STAT bytes_written 8930466
	STAT limit_maxbytes 4134304000
	STAT accepting_conns 1
	STAT listen_disabled_num 0
	STAT threads 4
	STAT bytes 151255336
	STAT current_items 57146
	STAT total_items 580656
	STAT evicitions 0
 *  
 *  这些参数反映着MemCache服务器的基本信息，它们的意思是：
 *  参  数  名 	作      用
	pid 	MemCache服务器的进程id 
	uptime 	服务器已经运行的秒数
	time 	服务器当前的UNIX时间戳 
	version 	MemCache版本 
	pointer_size 	当前操作系统指针大小，反映了操作系统的位数，64意味着MemCache服务器是64位的 
	rusage_user 	进程的累计用户时间 
	rusage_system  	进程的累计系统时间 
	curr_connections  	 当前打开着的连接数
	total_connections  	 当服务器启动以后曾经打开过的连接数
	connection_structures  	服务器分配的连接构造数 
	cmd_get  	get命令总请求次数 
	cmd_set 	set命令总请求次数 
	cmd_flush  	flush_all命令总请求次数 
	get_hits  	总命中次数，重要，缓存最重要的参数就是缓存命中率，以get_hits / (get_hits + get_misses)表示，比如这个缓存命中率就是99.2% 
	get_misses  	总未命中次数 
	auth_cmds  	认证命令的处理次数 
	auth_errors  	认证失败的处理次数 
	bytes_read  	总读取的字节数
	bytes_written  	总发送的字节数 
	 limit_maxbytes 	分配给MemCache的内存大小（单位为字节） 
	accepting_conns  	是否已经达到连接的最大值，1表示达到，0表示未达到
	listen_disabled_num  	统计当前服务器连接数曾经达到最大连接的次数，这个次数应该为0或者接近于0，如果这个数字不断增长， 就要小心我们的服务了
	threads  	当前MemCache总线程数，由于MemCache的线程是基于事件驱动机制的，因此不会一个线程对应一个用户请求 
	bytes  	当前服务器存储的items总字节数
	current_items  	当前服务器存储的items总数量 
	total_items  	自服务器启动以后存储的items总数量 
 *  
 *  
 *  stats slab指令解读
 *  如果对上面的MemCache存储机制比较理解了，那么我们来看一下各个slab中的信息，还是拿一组数据举个例子：
 *  
 *  STAT1:chunk_size 96
	...
	STAT 2:chunk_size 144
	STAT 2:chunks_per_page 7281
	STAT 2:total_pages 7
	STAT 2:total_chunks 50967
	STAT 2:used_chunks 45197
	STAT 2:free_chunks 1
	STAT 2:free_chunks_end 5769
	STAT 2:mem_requested 6084638
	STAT 2:get_hits 48084
	STAT 2:cmd_set 59588271
	STAT 2:delete_hits 0
	STAT 2:incr_hits 0
	STAT 2:decr_hits 0
	STAT 2:cas_hits 0
	STAT 2:cas_badval 0
	...
	STAT 3:chunk_size 216
	...
 *  
 *   首先看到，第二个slab的chunk_size（144）/第一个slab的chunk_size（96）=1.5，第三个slab的chunk_size（216）/第二个slab的chunk_size（144）=1.5，可以确定这个MemCache的增长因子是1.5，chunk_size以1.5倍增长。然后解释下字段的含义：
	参  数  名 	作      用
	chunk_size 	当前slab每个chunk的大小，单位为字节
	chunks_per_page 	每个page可以存放的chunk数目，由于每个page固定为1M即1024*1024字节，所以这个值就是（1024*1024/chunk_size）
	total_pages 	分配给当前slab的page总数
	total_chunks 	当前slab最多能够存放的chunk数，这个值是total_pages*chunks_per_page
	used_chunks 	已经被分配给存储对象的chunks数目
	free_chunks 	曾经被使用过但是因为过期而被回收的chunk数
	free_chunks_end 	新分配但还没有被使用的chunk数，这个值不为0则说明当前slab从来没有出现过容量不够的时候
	mem_requested 	当前slab中被请求用来存储数据的内存空间字节总数，（total_chunks*chunk_size）-mem_requested表示有多少内存在当前slab中是被闲置的，这包括未用的slab+使用的slab中浪费的内存
	get_hits 	当前slab中命中的get请求数
	cmd_set 	当前slab中接收的所有set命令请求数
	delete_hits 	当前slab中命中的delete请求数
	incr_hits 	当前slab中命中的incr请求数
	decr_hits 	当前slab中命中的decr请求数
	cas_hits 	当前slab中命中的cas请求数
	cas_badval 	当前slab中命中但是更新失败的cas请求数
	
	看到这个命令的输出量很大，所有信息都很有作用。举个例子吧，比如第一个slab中使用的chunks很少，第二个slab中使用的chunks很多，
	这时就可以考虑适当增大MemCache的增长因子了，让一部分数据落到第一个slab中去，适当平衡两个slab中的内存，避免空间浪费。
 *	
 *
 */
public class MemcacheTest {

}


















