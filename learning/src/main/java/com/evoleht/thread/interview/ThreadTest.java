package com.evoleht.thread.interview;

/**
 * 线程运行结果
 */
public class ThreadTest {
	
	public void methodA() {
		int i = 3;
		synchronized (this) {
			while (i-- > 0) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void methodB() {
		int i = 3;
		while (i-- > 0) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		final ThreadTest threadTest = new ThreadTest();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				threadTest.methodA();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				threadTest.methodB();
			}
		});
		
		t1.start();
		t2.start();
	}
}
