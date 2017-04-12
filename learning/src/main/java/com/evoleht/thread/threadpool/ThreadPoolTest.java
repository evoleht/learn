package com.evoleht.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		final int MAX_NUM = 10; 
		ExecutorService executor = null;
		
		/**
		 *	缓存线程池，使用时生成 
		 */
		executor = Executors.newCachedThreadPool();
		//executor = Executors.newCachedThreadPool(threadFactory);
		
		/**
		 *	固定大小的线程池   
		 */
		executor = Executors.newFixedThreadPool(MAX_NUM);
		//executor = Executors.newFixedThreadPool(MAX_NUM, threadFactory);
		
		/** 
		 *	单线程池 
		 */
		executor = Executors.newSingleThreadExecutor();
		//executor = Executors.newSingleThreadExecutor(threadFactory);
		
		/**
		 *	 
		 */
		executor = Executors.newScheduledThreadPool(MAX_NUM);
		//executor = Executors.newScheduledThreadPool(MAX_NUM, threadFactory);
		
		/**
		 *	 
		 */
		executor = Executors.newSingleThreadScheduledExecutor();
		//executor = Executors.newSingleThreadScheduledExecutor(threadFactory);
		
	}
}
