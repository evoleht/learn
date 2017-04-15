package com.evoleht.thread.synchronizedtest;


public class BussessClass {
	
	public synchronized static void methodA() {
		 System.out.println("线程："+Thread.currentThread().getName()+"正在执行methodA()...");
		 try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("线程：" + Thread.currentThread().getName() + "正在执行methodB()....");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
