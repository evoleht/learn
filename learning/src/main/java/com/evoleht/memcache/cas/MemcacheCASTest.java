package com.evoleht.memcache.cas;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.sun.org.apache.bcel.internal.generic.NEW;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcacheCASTest {
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
				Object[] result = {1,new HashMap<String, String>()};
				
				result[0] = 0;
				HashMap<String, String> map = (HashMap<String, String>) result[1];
				map.put("1", "1");
				client.set(key, 0, result);
				
				boolean flag  = client.cas(key, 0, new CASOperation<Object>() {
					int count = 0;
					@Override
					public int getMaxTries() {
						count++;
						System.out.println("尝试次数:"+count);
						return 3;
					}
					@Override
					public Object getNewValue(long currentCAS, Object currentValue) {
						System.out.println("获取新值");
						Object[] result = (Object[])currentValue;
						result[0] = 1;
						HashMap<String, String> map = (HashMap<String, String>) result[1];
						map.put("1", "2");
						return result;
					}
				});
				
				System.out.println("-------------->"+flag);
				
				Object[] result1 = client.get(key);
				System.out.println("数组第0个:"+result1[0]);
				System.out.println("Map第1个:"+((HashMap<String, String>) result1[1]).get("1"));
				
				
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
