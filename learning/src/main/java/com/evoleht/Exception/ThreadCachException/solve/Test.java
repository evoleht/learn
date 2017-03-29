package com.evoleht.Exception.ThreadCachException.solve;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.singleThread();
		t.everyThread();
		t.unifyHandler();
	}
	
	public void singleThread() {
		ExceptionThreadTest t = new ExceptionThreadTest();
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		t.start();
	}
	
	/**
	 * 
	 * 按照具体的情况逐个地设置处理器
	 * 
	 */
	public void everyThread() {
		ExecutorService pool = Executors.newCachedThreadPool(new HandlerThreadFactory());
		pool.execute(new ExceptionThreadTest());
		pool.shutdown();
	}
	
	/**
	 * 所有线程的统一相同的异常处理器
	 * 说明：这个处理器只有在不存在线程专有的未捕获异常的情况下才会被调用。系统会检查线程的专有的版本，如果没有发现，
	 * 则检查线程组是有有其专有的uncaughtException()方法。如果也没有，在调用defaultUncaughtExcept
	 */
	public void unifyHandler() {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		new ExceptionThreadTest().start();
	}
}
