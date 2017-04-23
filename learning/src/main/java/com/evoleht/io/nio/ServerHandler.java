package com.evoleht.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import javax.script.ScriptException;

import com.evoleht.io.Calculator;

public class ServerHandler implements Runnable {
	
	private Selector selector;
	
	private ServerSocketChannel serverChannel;

	private volatile boolean started;
	
	public ServerHandler(int port) {
		try {
			selector = Selector.open();
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(port),1024);
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			started = true;
			System.out.println("服务器已经启动,端口：" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		started = false;
	}
	
	@Override
	public void run() {
		while(started) {
			try {
				selector.select(1000);
				Set<SelectionKey>  keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while(iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			selector = null;
		}
	}
	
	public void handleInput(SelectionKey key) throws IOException {
		if(key.isValid()) {
			if(key.isAcceptable()) {
				ServerSocketChannel chanl = (ServerSocketChannel) key.channel();
				SocketChannel schanl = chanl.accept();
				schanl.configureBlocking(false);
				schanl.register(selector, SelectionKey.OP_READ);
			}
		}
		
		if(key.isReadable()) {
			SocketChannel sc = (SocketChannel) key.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int readBytes = sc.read(buffer);
			if(readBytes > 0) {
				buffer.flip();
				byte[] bytes = new byte[buffer.remaining()];
				buffer.get(bytes);
				String expression = new String(bytes,"utf-8");
				//处理数据
				String result = null;
				try {
					result = Calculator.cal(expression).toString();
				} catch (ScriptException e) {
					System.out.println("计算错误:" + e.getMessage());
				}
				//发送应答消息
				doWrite(sc, result);
			}else if(readBytes < 0) {
				key.cancel();
				sc.close();
			}
		}
	}
	
	private void doWrite(SocketChannel channel, String response) throws IOException {
		byte[] bytes = response.getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		channel.write(writeBuffer);
	}

}

















