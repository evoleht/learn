package com.evoleht.base.baseclass.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>(); 
		/* 
		 * CopyOnWriteArrayList 实现list接口，用法与ArrayList 基本一样
		 * 区别:
		 * 1.它是线程安全的，可以被多个线程并发访问
		 * 2.迭代器不支持修改操作，也不会抛出ConcurrentModificationException
		 * 3.以原子的方式支持一些复合操作
		 *
		 * 原理：
		 *  内部是一个初始默认为0的数组，这个数组是以原子的方式被整体更新。
		 *  每次操作都会新建一个数组，复制原数组的内容到新数组，在新数组上进行需要的修改，然后以原子的方式
		 *  设置内部的数组引用，这就是写时拷贝
		 *  所有的读操作，都是先拿到当前引用的数组，然后直接访问该数组，在读的过程中，可能内部数组引用已经被
		 *  修改了，但是不影响读操作，它依旧访问原数组的内容
		 *  
		 *  换句话说，数组内容是只读的，写操作都是通过新建数组，然后原子性的修改数组引用来实现的。
		 *  
		 *  
		 *  private volatile transient Object[] array;
		 *  
		 *  数组声明为volatile 类型，保证了内存可见性。写操作完成之后，读操作能看到。
		 *  
		 *  final transient ReentrantLock lock;
		 *  内部使用的ReentrantLock
		 *  
		 *  add(E e) 
		 *  add方法是修改操作，整个过程被锁保护起来，先拿到当前的数组对象引用，然后复制了个长度+1的新数组
		 *  ，在新数组中添加元素，然后setArray  arr = newArr
		 *  
		 *  indexOf(Object o, Object[] elements, int index, int fence)
		 *  
		 *  indexOf方法访问的所有数据都是通过参数传递过来的，数组内容也不会被修改，不存在并发问题
		 *  
		 *  iterator()
		 *  COWIterator 是内部类，传递给它的是不变的数组，它也是只读数组，不支持修改。
		 *  
		 *  
		 *  CopyOnWriteArrayList 不适用于数组很大，且修改频繁的场景。它是以优化读操作为目标的，
		 *  读不需要同步，性能很高，但是在优化读的同时牺牲了写的性能。
		 *  
		 *  
		 *  
		 */
		list.add("a");
	}
	
}
