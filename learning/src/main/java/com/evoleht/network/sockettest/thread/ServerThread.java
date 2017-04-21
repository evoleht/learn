package com.evoleht.network.sockettest.thread;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket con;
	private int num;
	
	public ServerThread(Socket con, int num) {
		this.con = con;
		this.num = num;
	}
	
	@Override
	public void run() {
		OutputStream out = null;
		Writer writer = null;
		try {
			 out = new BufferedOutputStream(con.getOutputStream());
			 writer = new OutputStreamWriter(out);
			 //模拟线程耗时
			 try {
				Thread.sleep(3000);
			 } catch (InterruptedException e) {
			 	e.printStackTrace();
			 }
			 
			 String str = "hello "+num+", I'm server";
			 writer.write(str);
			 writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (out != null) out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (writer != null) writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (con != null) con.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
