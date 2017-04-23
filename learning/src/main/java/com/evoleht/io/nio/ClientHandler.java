package com.evoleht.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientHandler implements Runnable {
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean started;
	
	public ClientHandler(String host, int port){
		this.host = host;
		this.port = port;
		
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			started = true;
			System.out.println("客户端启动..");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		started = false;
	}
	
	@Override
	public void run() {
		try {
			doConnect();
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(started) {
			try {
				selector.select(1000);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while(it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key != null) {
							key.cancel();
							if(key.channel() != null) {
								key.channel().close();
							}
						}
					}	
					
				}
					
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}
		
		if(selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void handleInput(SelectionKey key) throws IOException {
		if(key.isValid()) {
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable()) {
				if(sc.finishConnect());
				else System.exit(1);
			}
			
			//读消息
			if(key.isReadable()) {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(buffer);
				if(readBytes > 0) {
					buffer.flip();
					byte[] bytes = new byte[buffer.remaining()];
					buffer.get(bytes);
					String result = new String(bytes,"utf-8");
					System.out.println("客户端收到的信息:"+result);
				}else if(readBytes < 0) {
					key.cancel();
					sc.close();
				}
			}
		}
		
	}
	
	private void doConnect() throws ClosedChannelException, IOException {
		if(socketChannel.connect(new InetSocketAddress(host,port)));
		else socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	public void sendMsg(String msg) throws IOException {
		socketChannel.register(selector, SelectionKey.OP_READ);
		doWrite(socketChannel, msg);
	}
	
	private void doWrite(SocketChannel channel, String request) throws IOException {
		byte[] bytes = request.getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.put(bytes);
		buffer.flip();
		channel.write(buffer);
	}
}





	




























