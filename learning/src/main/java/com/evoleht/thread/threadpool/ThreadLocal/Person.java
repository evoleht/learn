package com.evoleht.thread.threadpool.ThreadLocal;

public class Person {
	
	private String name;
	ThreadLocal<String> threadLocal = new ThreadLocal<String>(); 
	
	public void print() {
		System.out.println("线程："+Thread.currentThread().getName()+"-1person 当前的名字为: "+name +"--可能会存在问题");
		System.out.println("线程："+Thread.currentThread().getName()+"-2Person 当前的名字为: "+getName() +"--正确");
	}
	
	public void setName(String name) {
		this.name = name;
		if(threadLocal.get() == null) {
			threadLocal.set(this.name);
		}
		//模拟耗时操作
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public String getName() {
		String name = threadLocal.get();
		return name;
	}
}
