package com.evoleht.Exception.ThreadCachException.question;

public class ExceptionThreadTest extends Thread {
	
	@Override
	public void run(){
		System.out.println("线程运行时抛出异常");
		
		//test(); //run 方法无法抛出checked excetion。所有的checked exception 都必须 try catch掉
		throw new RuntimeException();
	}
	
	public void test() throws Exception {
		System.out.println("抛出异常的方法");
	}
}
