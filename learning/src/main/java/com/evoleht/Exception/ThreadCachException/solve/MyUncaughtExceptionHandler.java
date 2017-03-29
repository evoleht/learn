package com.evoleht.Exception.ThreadCachException.solve;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println("线程 "+ thread.getName() + "发生异常");
		System.out.println(throwable);
	}

}
