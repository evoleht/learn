package com.evoleht.thread.synchronizedtest;

public class Test {
	
	public static void main(String[] args) {
		BussessClass bussess = new BussessClass();
		BussessClass bussess2 = new BussessClass();
		for (int i = 0; i < 10; i++) {
			Thread a = new ThreadA(bussess);
			a.setName("线程A"+i);
			a.start();
			
			Thread b = new ThreadB(bussess);
			b.setName("线程B"+i);
			b.start();
			
			Thread c = new ThreadC(bussess);
			c.setName("线程C"+i);
			c.start();
			
			Thread aa = new ThreadA(bussess2);
			aa.setName("线程Aa"+i);
			aa.start();
			
			Thread bb = new ThreadB(bussess2);
			bb.setName("线程Bb"+i);
			bb.start();
			
			Thread cc = new ThreadC(bussess2);
			cc.setName("线程Cc"+i);
			cc.start();
			
		}
		
	
	}
}
