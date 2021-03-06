package com.evoleht.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.swing.internal.plaf.synth.resources.synth;

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
				new Thread(new ServerHandler(socket)).start();
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
























