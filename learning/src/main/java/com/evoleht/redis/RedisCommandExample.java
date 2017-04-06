package com.evoleht.redis;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 
* <p>redis 操作示例</p>
* @ClassName: RedisUtil
* @author: wang
* @date 2015年8月29日 上午11:50:45
*
 */
public class RedisCommandExample {

	public RedisCommandExample() {
	}
	
	public static void main(String[] args) {
		//KVStore的连接信息，从控制台可以获得
		//String host = "ebd7c0a62727416f.m.cnhza.kvstore.aliyuncs.com";
		String host = "192.168.1.202";
		int port = 6379;
		Jedis jedis = new Jedis(host, port);
////		try {
////			//KVStore的实例ID及密码
////			String authString = jedis.auth("ebd7c0a62727416f:ae3290392vnoei3888Q");//kvstore_instance_id:password
////			if (!authString.equals("OK"))
////			{
////			System.err.println("AUTH Failed: " + authString);
////			return;
////			}
////		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			jedis.quit();
//			jedis.close();
//		}
		//Jedis jedis = RedisClient.getInstance();
		System.out.println("jedis:"+jedis);
		
		String key = "1000_110000_ranking_exam";
		jedis.zadd(key, 680, 680+"");
		jedis.zadd(key, 680, 680+"");
		jedis.zadd(key, 700, 700+"");
		jedis.zadd(key, 570, 570+"");
		jedis.zadd(key, 590, 590+"");
		jedis.zadd(key, 590, 590+"");
		
		//第一名
		Set<String> scoreSet = jedis.zrevrange(key, 0, 0);
		for(String score : scoreSet){
			System.out.println("第一名是："+score);
		}
		
		//我的排名 获取的index+1
		long index = jedis.zrevrank(key,680+"")+1;
		System.out.println("我的排名是："+index);
		
		
		//总人数
		key = "1000_110000_totalnum_exam";
		jedis.hset(key, 10000+"", 680+"");
		jedis.hset(key, 10001+"", 700+"");
		jedis.hset(key, 10101+"", 590+"");
		jedis.hset(key, 10102+"", 590+"");
		jedis.hset(key, 10103+"", 680+"");
		jedis.hset(key, 10105+"", 570+"");
		System.out.println("参与总人数是："+jedis.hlen(key));
		System.out.println(jedis.hget(key,10102+""));
		
		
	}
}
