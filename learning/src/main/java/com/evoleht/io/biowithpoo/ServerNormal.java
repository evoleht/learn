package com.evoleht.io.biowithpoo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端
 * @author wangzs
 *
 */
public class ServerNormal {
	
	/** 默认端口号 */
	private static int DEFAULT_PORY = 1234;
	
	/** serversocket */
	private static ServerSocket server;
	
	private static ExecutorService pool  = Executors.newFixedThreadPool(50);
	public static void start() throws IOException {
		start(DEFAULT_PORY);
	}
	
	public synchronized static void start(int port) throws IOException {
		if(server != null) return;
		try {
			server = new ServerSocket(port);
			System.out.println("服务器已经启动....");
			Socket socket;
			while(true) {
				socket = server.accept();
				pool.execute(new ServerHandler(socket));
			}
		} finally {
			if(server != null) {
				System.out.println("服务器已经关闭...");
				server.close();
				server = null;
			}
		}
		
	}
}
























