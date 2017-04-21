package com.evoleht.network.sockettest.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSimpleTest {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(13);
			while(true) {
				Socket con = null;
				try {
					con = serverSocket.accept();
					System.out.println("-----");
					OutputStream out = con.getOutputStream();
					Writer writer = new OutputStreamWriter(out,"utf-8");
					String str = "hello, I'm server";
					writer.write(str);
					writer.flush();
					writer.close();
					out.close();
				} catch (IOException e) {
					//一个客户端的问题，不会导致服务器关闭
					e.printStackTrace();
				}finally {
					try {
						if(con != null) con.close();
					} catch (IOException e2) {
					}
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
