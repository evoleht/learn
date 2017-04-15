package com.evoleht.thread.synchronizedtest;

public class ThreadB extends Thread{
	
	private BussessClass bussess;
	
	public ThreadB(BussessClass bussess) {
		this.bussess = bussess;
	}
	@Override
	public void run() {
		bussess.methodB();
	}
}
