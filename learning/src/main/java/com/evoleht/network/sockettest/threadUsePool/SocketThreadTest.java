package com.evoleht.network.sockettest.threadUsePool;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketThreadTest {
	
	private static final int DEFAULT_PORT = 13;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 30; i++) {
			new Thread() {
				public void run() {
					Socket scoket = null;
					InputStream in = null;
					InputStreamReader reader = null;
					System.out.println("线程："+Thread.currentThread().getName()+"-启动......");
					try {
						scoket = new Socket("127.0.0.1", DEFAULT_PORT);
						in = new BufferedInputStream(scoket.getInputStream());
						reader = new InputStreamReader(in,"utf-8");
						StringBuilder sb = new StringBuilder();
						for (int c = reader.read(); c !=-1; c = reader.read()) {
							sb.append((char)c);
						}
						System.out.println("线程："+Thread.currentThread().getName()+"-服务器返回："+sb.toString());
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}finally {
						try {
							if (scoket !=null) {
								scoket.close();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (in != null) {
							try {
								in.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (reader != null) {
							try {
								reader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				};
			}.start();
		}
	}
}
