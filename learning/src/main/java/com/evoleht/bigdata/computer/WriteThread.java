package com.evoleht.bigdata.computer;


public class WriteThread extends Thread{
	private Writer writer;
	
	public WriteThread(Writer writer) {
		this.writer = writer;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " 启动：");
			writer.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
