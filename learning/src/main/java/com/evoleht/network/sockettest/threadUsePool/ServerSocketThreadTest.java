package com.evoleht.network.sockettest.threadUsePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketThreadTest {
	
	private static final int MAX_THREAD_NUM = 10; 
	private static final int DEFAULT_PORT = 13;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		ExecutorService pool = null;
		int count = 0;
		try {
			System.out.println("服务器开始启动......");
			serverSocket = new ServerSocket(DEFAULT_PORT);
			System.out.println("服务器已经启动,开始监听端口：" + DEFAULT_PORT);
			
			System.out.println("启用线程池........");
			pool = Executors.newFixedThreadPool(MAX_THREAD_NUM);
			
			while(true) {
				Socket con = null;
				try {
					con = serverSocket.accept();
					count++;
					System.out.println("服务器监听到一个连接....."+count);
					pool.submit(new ServerThread(con, count));
				} catch (IOException e) {
					//一个客户端的问题，不会导致服务器关闭
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (serverSocket !=null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (pool != null) {
				pool.shutdown();
			}
		}
	}
}
