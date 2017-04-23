package com.evoleht.io.nio;

import java.io.IOException;

public class Client {
	
	private static String DEFAULT_HOST = "127.0.0.1";
	private static int DEFAULT_PORT = 1234;
	private static ClientHandler clientHandler;
	
	public static void start() {
		start(DEFAULT_HOST, DEFAULT_PORT);
	}
	
	public static void start(String ip, int port) {
		if(clientHandler != null) {
			clientHandler.stop();
		}
		clientHandler = new ClientHandler(ip, port);
		new Thread(clientHandler,"Client").start();
	}
	
	//向服务器发送消息
	public static boolean sendMsg(String msg) throws IOException {
		if(msg.equals("q")) return false;
		clientHandler.sendMsg(msg);
		return true;
	}
	
	public static void main(String[] args) {
		start();
	}
	
}
