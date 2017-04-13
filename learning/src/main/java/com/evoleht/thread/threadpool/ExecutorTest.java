package com.evoleht.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	/**
	 * 1.Executor主要作用
	 * 	(1).并发控制
	 * 	(2).资源的有效利用，线程重复使用，避免了线程的创建、销毁的开销
	 * 	
	 * 2.Executor的整体结构
	 * 		Executor.png
	 * 
	 * 3.结构体系介绍
	 * 	(1)接口Executor 定义了executor方法用于接受用户提交的任务
	 *  (2)接口ExecutorService 定义了 shutdown、shutdownnow、submit 等方法
	 *  (3)AbstracrExecutorService 实现了任务的提交等一些方法
	 *  (4)ThreadPoolExecutor 核心类，线程池的内部实现
	 *  (5)ScheduledThreadPoolExecutor 在ThreadPoolExecutor的基础上提供的定时调度的功能，线程任务可以在一段时间之后被定时触发。
	 * 
	 * 3.1.ThreadPoolExcutor 原理
	 * 
	 * ThreadPoolExecutor.java---->public void execute(Runnable command) 
	 * 
	 * 3.2.ScheduledThreadPoolExecutor原理
	 * 
	 * 4.线程池的使用策略
	 * 
	 * 
	 * 5.拒绝策略
	 	RejectedExecutionHandler 是拒绝的策略。常见有以下几种：

		AbortPolicy ：不执行，会抛出 RejectedExecutionException 异常。
		
		CallerRunsPolicy ：由调用者（调用线程池的主线程）执行。
		
		DiscardOldestPolicy ：抛弃等待队列中最老的。
		
		DiscardPolicy: 不做任何处理，即抛弃当前任务。
 
	 */
	
	public void createPool() {
		final int MAX_NUM = 10; 
		ExecutorService executor = null;
		
		/**
		 *	缓存线程池，核心线程数为0。线程不够时，创建新线程，最大为int.MAX_VALUE
		 *	线程默认空闲存活60秒超过则结束。 阻塞队列采用 SynchronousQueue
		 */
		executor = Executors.newCachedThreadPool();
		//executor = Executors.newCachedThreadPool(threadFactory);
		
		/**
		 *	固定大小的线程池,阻塞队列采用 LinkedBlockingQueue。
		 *
		 */
		executor = Executors.newFixedThreadPool(MAX_NUM);
		//executor = Executors.newFixedThreadPool(MAX_NUM, threadFactory);
		
		/** 
		 * 固定大小为一个线程的线程池。阻塞队列采用LinkedBlockingQueue
		 */
		executor = Executors.newSingleThreadExecutor();
		//executor = Executors.newSingleThreadExecutor(threadFactory);
		
		executor = Executors.newScheduledThreadPool(MAX_NUM);
		//executor = Executors.newScheduledThreadPool(MAX_NUM, threadFactory);
		
		executor = Executors.newSingleThreadScheduledExecutor();
		//executor = Executors.newSingleThreadScheduledExecutor(threadFactory);
	}
	
}
