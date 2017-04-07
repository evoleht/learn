package com.evoleht.thread.interview.inorderexecution;

public class TestB {
	public static volatile int index = 1;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (index != 1) {
						continue;
					}
					System.out.println("执行线程1");
					index = 2;
					break;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (index != 2) {
						continue;
					}
					System.out.println("执行线程2");
					index = 3;
					break;
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (index != 3) {
						continue;
					}
					System.out.println("执行线程3");
					break;
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
	}
}
