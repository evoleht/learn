package com.evoleht.Exception.ThreadCachException.solve;


public class ExceptionThreadTest extends Thread{
	
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t.getName());
		System.out.println("ehandler : "+ t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}
