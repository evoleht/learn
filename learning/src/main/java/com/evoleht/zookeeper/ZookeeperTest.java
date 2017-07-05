package com.evoleht.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {
	
	public static void main(String[] args) {
		
		try {
			ZooKeeper zk = new ZooKeeper("127.0.0.1:2180", 100, null);
			String path = "/dmc";
			
			zk.create(path, "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println("创建节点 " + path + ", 数据为: " + new String(zk.getData(path, null, null)));
			
			zk.setData(path, "2".getBytes(), -1);
			System.out.println("修改节点" + path + ", 数据为: " + new String(zk.getData(path, null, null)));
			
			System.out.println(zk.exists(path, null));
			zk.delete(path, -1);
			
			System.out.println(zk.exists(path, null));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

















