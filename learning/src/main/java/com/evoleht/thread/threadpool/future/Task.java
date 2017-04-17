package com.evoleht.thread.threadpool.future;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	private int id;
	Task(int id) {
		this.id = id;	
	}
	@Override
	public String call() throws Exception {
		System.out.println("call()方法被调用，线程"+Thread.currentThread().getName()+"开始工作！");
		if(new Random().nextBoolean()) {
			throw new TaskException("Meet eorr in task" + Thread.currentThread().getName());
		}
		if(id == 2) {
			Thread.sleep(10000);
		}
		Thread.sleep(new Random().nextInt(10)*500);
		return "call()方法被自动调用，任务的结果是："+id+"--"+Thread.currentThread().getName();
	}

}
