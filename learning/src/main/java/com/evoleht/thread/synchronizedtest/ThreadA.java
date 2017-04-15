package com.evoleht.thread.synchronizedtest;



public class ThreadA extends Thread{
	
	private BussessClass bussess;
	
	ThreadA(BussessClass bussess) {
		this.bussess = bussess;
	}
	
	@Override
	public void run() {
		bussess.methodA();
	}
}
