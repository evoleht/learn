package com.evoleht.thread.threadpool;

import java.util.ArrayList;
import java.util.List;

public class SingleThreadPoolExecutorTest {
	static int userNum = 20;
	
	/**
	 * 	使用单线程池与自己创建线程的区别
	 * 
	 *  理解：
	 *  1.明确执行的任务 （线程池）
	 *  2.线程不需要频繁的创建修改
	 *  3.线程不需要重用
	 *  如果满足这几个条件可以不用线程池，因为线程池里会创建一些额外的对象，需要有维护线程的地方
	 *  处理异常的方式，反而造成额外的浪费
	 *  反之则需要使用单线程池。
	 *
	 *	示例：记录在线用户数量的功能，记录操作异步独立运行，
	 */
	public static void recordNum() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("在线人数为："+userNum);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	/**
	 * 该线程会一直存在，异步独立运行着。这个场景下功能比较简单，
	 * 是没必要采用singleThreadExecutor的。singleThreadExecutor是通过创建一个线程池来管理。
	 * 内部做了大量处理，如自定义很多处理类、建立容器接收任务、处理任务时的加锁解锁操作、线程的状态判断等等。
	 * 采用后者相关于做了很多没必要的工作。且内存占用也比前者多
	 * 
	 * 换一种场景：现在需要提供当有用户登录或者退出时记录用在线人数。记录操作异步执行
	 * 
	 */
	public static void login() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("用户登录，在线人数为:"+userNum);
			}
		}).start();
	}
	
	public static void logout() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("用户下线，在线人数为:"+userNum);
			}
		}).start();
	}
	/**
	 * 程序调整之后，发现线程频繁创建、销毁，把程序在调整一下
	 */
	static RecordThread th = null;
	static {
		th = new RecordThread();
		th.start();
		System.out.println("记录线程开始启动....");
	}
	
	public static void loginA() {
		th.addTask(new Runnable() {
			@Override
			public void run() {
				System.out.println("用户登录,在线人数为:"+userNum);
			}
		});
	}
	
	public static void logoutA() {
		th.addTask(new Runnable() {
			@Override
			public void run() {
				System.out.println("用户下线，在线人数为："+userNum);
			}
		});
	}
	
	/**
	 * 程序调整之后，我们会发现新的问题，线程并发安全问题 ArrayList，线程异常中断问题都没有处理
	 * 后续代码继续优化，最后会发现我们正在重写一个SingleThreadPoolExecutor
	 */
	public static void main(String[] args) {
		//recordNum();
		//login();
		//logout();
		
		loginA();
		logoutA();
		
	}
}


class RecordThread extends Thread {
	List<Runnable> list = new ArrayList<Runnable>();
	
	@Override
	public void run() {
		while(true) {
			if (list.size() > 0) {
				Runnable task = list.remove(0);
				task.run();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addTask(Runnable task) {
		list.add(task);
	}
}