package com.evoleht.memcache;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XmemcacheTest {
	public static void main(String[] args) {
		MemcachedClientBuilder builder =  new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"));
		//最多连接数
		builder.setConnectionPoolSize(5);
		//使用二进制文件
		builder.setCommandFactory(new BinaryCommandFactory());
		//使用序列化传输编码
		builder.setTranscoder(new SerializingTranscoder());
		//使用压缩，设置压缩阀值，单位为字节
		builder.getTranscoder().setCompressionThreshold(1);
		try {
			MemcachedClient client = builder.build();
			//设置超时时间
			client.setOpTimeout(10000L);
			//设置心跳检测
			client.setEnableHeartBeat(false);
			try {
				String key = "test";
				boolean flag = client.set("test", 0, "testvalue");
				String str = client.get("test");
				System.out.println(str);
				
				GetsResponse<String> obj = client.gets(key);
				long cas = obj.getCas();
				if(!client.cas(key, 0,"updatevalue", cas)){
					System.out.println("更新失败!");
				}else {
					System.out.println(client.get(key));
				}
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
