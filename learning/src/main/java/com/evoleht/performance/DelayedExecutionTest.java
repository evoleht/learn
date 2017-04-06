package com.evoleht.performance;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class DelayedExecutionTest {
	
	public void test() throws InterruptedException, ExecutionException {
		//一些不可以并行执行的操作
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				for (int i = 0; i < 100000; i++) {
					//一些计算操作
				}
				return "result";
			}
		};
		
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		new Thread(futureTask).start();
		
		//其它操作
		for (int i = 0; i < 2000; i++) {
			//其它一些计算操作
		}
		
		String str = futureTask.get();
		
		System.out.println("程序计算的结果为："+str);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		DelayedExecutionTest t = new DelayedExecutionTest();
		t.test();
	}
}
