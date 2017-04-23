package com.evoleht.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.script.ScriptException;

import com.evoleht.io.Calculator;

public class ServerHandler implements Runnable {
	private Socket socket;
	
	public ServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			String expression = null;
			String result = null;
			
			while(true) {
				if((expression =in.readLine()) == null) break;
				System.out.println("服务器收到消息：" + expression);
				try {
					result = Calculator.cal(expression).toString();
				} catch (ScriptException e) {
					System.out.println("计算错误:"+e.getMessage());
				}
				out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if(out != null) {
				try {
					out.close();
				} catch (Exception e2) {
				}
				out = null;
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
				
		}

	}

}
