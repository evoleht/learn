package com.evoleht.memcache.consistenthashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashingWithoutVirtualNode {
	
	/**
	 * 待加入hash环的服务器列表
	 */
	private static String[] servers = { "192.168.0.0:1111", "192.168.0.1:1111",
			"192.168.0.2:1111", "192.168.0.3:1111" };
	/**
	 *  key表示服务器的hash值，value表示服务器地址
	 */
	private static SortedMap<Integer, String> sortMap = new TreeMap<Integer, String>();
	
	/**
	 *  程序初始化，将服务器列表加入hash环
	 */
	static {
		for (int i = 0; i < servers.length; i++) {
			int hash = HashUtil.getHash(servers[i]);
			System.out.println("服务器["+servers[i]+"]加入集合，其hash值为：" + hash);
			sortMap.put(hash, servers[i]);
		}
	}
	
	public static String getServer(String node) {
		//计算带路由的节点的hash值
		int hash = HashUtil.getHash(node);
		// 得到大于该Hash值的所有Map
		SortedMap<Integer, String> subMap = sortMap.tailMap(hash);
		//第一个key就是顺时针过去离node节点最近的那个节点
		Integer server = subMap.firstKey();
		//返回服务器对应的地址
		return sortMap.get(server);
	}
	
	public static void main(String[] args) {
		String[] nodes = { "127.0.0.1:1111", "127.0.0.2:2222", "127.0.0.3:3333" };
		for (int i = 0; i < nodes.length; i++) {
			System.out.println("["+ nodes[i] +"] 的hash值为："+HashUtil.getHash(nodes[i])+"," +
					"被路由到的服务器为"+getServer(nodes[i]));
		}
	}
}
