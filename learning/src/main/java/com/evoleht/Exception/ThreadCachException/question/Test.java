package com.evoleht.Exception.ThreadCachException.question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		try {
			ExceptionThreadTest et = new ExceptionThreadTest();
//			et.start();
			ExecutorService pool = Executors.newFixedThreadPool(1);
			pool.execute(et);
			
		} catch (Exception e) {
			System.out.println("捕捉到异常");
		}
		System.out.println("未捕捉到异常");
	}
}
