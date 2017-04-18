package com.evoleht.thread.synchronizedtest;



public class ThreadC extends Thread{
	
	private BussessClass bussess;
	
	ThreadC(BussessClass bussess) {
		this.bussess = bussess;
	}
	
	@Override
	public void run() {
		bussess.methodC();
	}
}
