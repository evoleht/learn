package com.evoleht.io.nio;

public class Server {
	
	private final static int DEFAULT_PORT = 1234;
	
	private static ServerHandler serverHandler;
	public static void start() {
		start(DEFAULT_PORT);
	}
	
	public static void start(int port) {
		if(serverHandler != null) serverHandler.stop();
		
		serverHandler = new ServerHandler(port);
		new Thread(serverHandler,"Server").start();
	}
	
	public static void main(String[] args) {
		start();
	}
}
