package com.evoleht.thread.interview.inorderexecution;

public class TestA {
	
	public static void main(String[] args) {
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程1开始执行");
			}
		});
		
		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程2开始执行");
			}
		});
	
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程3开始执行");
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
