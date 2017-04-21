package com.evoleht.network.sockettest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerSocketTest {
	
	private static final int DEFAULT_PORT = 13;//默认端口
	private static final int DEFAULT_QUEUELENGTH = 50; //默认一次最多可以保存的入站连接
	
	public static void main(String[] args) {
		//构造服务器ServerSocket
		try {
			//method 1
			ServerSocket socket = new ServerSocket(DEFAULT_PORT);
			
			//method 2
			//在端口13 创建一个HTTP服务器使用的服务器Socket，而且队列一次最多可以保存50个入站连接
			ServerSocket socket2 = new ServerSocket(DEFAULT_PORT, DEFAULT_QUEUELENGTH);
			
			//默认的，如果一个主机有多个网络接口或IP地址，服务器Socket会在所有接口和IP地址的指定端口上监听。不过可以增加第三个参数
			//要求只绑定一个特定的本地IP地址。也就是说，服务器Socket只监听这个地址上的入站连接。它不会监听通过这个主机的其它地址进入的连接。
			//例：一台Linux服务器，他用ip 152.128.220.122 连入 Internet。这个机器还有第二快以太网卡，其本地IP地址是 192.168.210.122
			//公供Internet看不倒这个地址，只有本地网络能看到。如果处于某种原因，你希望在这个主机上运行一个服务器，它只响应同一个网络中的本地连接，可以创建一个服务器
			//Socket，监听192.168.210.122上的13端口。而不会监听152.128.220.122上的13端口
			InetAddress local = InetAddress.getByName("192.168.210.122");
			ServerSocket socket3 = new ServerSocket(DEFAULT_PORT, DEFAULT_QUEUELENGTH, local);
			
			//构造但不绑定端口
			ServerSocket socket4 = new ServerSocket();
			SocketAddress address = new InetSocketAddress(DEFAULT_PORT);
			socket4.bind(address);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


















