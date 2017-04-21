package com.evoleht.network.sockettest.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerSocketThreadTest {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int count = 0;
		try {
			System.out.println("服务器开始启动......");
			serverSocket = new ServerSocket(13);
			System.out.println("服务器已经启动,开始监听端口：13");
			while(true) {
				Socket con = null;
				try {
					con = serverSocket.accept();
					count++;
					System.out.println("服务器监听到一个连接....."+count);
					new ServerThread(con, count).start();
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
		}
	}
}
