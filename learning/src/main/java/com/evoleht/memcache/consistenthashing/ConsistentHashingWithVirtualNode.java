package com.evoleht.memcache.consistenthashing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashingWithVirtualNode {
	
	/**
	 * 服务器列表
	 */
	private static String[] servers = { "192.160.0.0:1111", "192.168.0.1:1111",
			"192.168.0.2:1111" };
	
	/**
	 * key 为服务器hash值，value为服务器地址
	 */
	private static SortedMap<Integer, String> sortMap = new TreeMap<Integer, String>();
	
	/**
	 *  考虑到服务器经常添加删除，所以采用linkedlist
	 */
	private static LinkedList<String> realNodes = new LinkedList<String>();
	
	/**
	 * 虚拟节点的数目，这里写死，为了掩饰，一个真实节点对应5个虚拟节点
	 */
	private static final int VIRTUAL_NODES = 5;
	
	/**
	 *  初始化，将服务器列表添加到环空间
	 */
	static {
		for (int i = 0; i < servers.length; i++) {
			//先将原始的服务器添加到真实的节点列表中
			realNodes.add(servers[i]);
			//一个真是节点对应VIRTUAL_NODES个虚拟节点
			for (int j = 0; j < VIRTUAL_NODES; j++) {
				String virtualNodeName = servers[i] +"&&vn"+j;
				int hash = HashUtil.getHash(virtualNodeName);
				System.out.println("服务器["+servers[i]+"]对应的虚拟节点：["+virtualNodeName+"]添加到环空间，" +
						"对应的hash值为："+hash);
				sortMap.put(hash, virtualNodeName);
			}
		}
	}
	
	/**
	 * 获取带路由节点对应的服务器 
	 */
	public static String getServer(String node) {
		//带路由节点的hash值
		int hash = HashUtil.getHash(node);
		//离节点最近的一个服务器地址
		SortedMap<Integer, String> subMap = sortMap.tailMap(hash);
		int firstKey = 0;
		//max最大值则循环取第一个
		if(subMap.size() == 0) {
			firstKey = sortMap.firstKey();
		}else {
			firstKey = subMap.firstKey();
		}
		String virtualName = sortMap.get(firstKey);
		return virtualName.substring(0,virtualName.indexOf("&"));
	}
	
	public static void main(String[] args) {
		String[] nodes = {"127.0.0.1:1111","127.0.0.2:2222","127.0.0.3:3333"};
		for (int i = 0; i < nodes.length; i++) {
			System.out.println("client:["+nodes[i]+"]的hash值为："+HashUtil.getHash(nodes[i])+"它被路由到" +
					"服务器："+getServer(nodes[i]));
		}
	}
}
