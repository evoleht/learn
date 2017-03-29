package com.evoleht.Exception.ThreadCachException.solve;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable runnable) {
		Thread t = new Thread(runnable);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}

}
