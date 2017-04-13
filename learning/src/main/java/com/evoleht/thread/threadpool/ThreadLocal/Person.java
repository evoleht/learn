package com.evoleht.thread.threadpool.ThreadLocal;

public class Person {
	
	private String name;
	private ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public void print() {
		System.out.println("线程："+Thread.currentThread().getName()+"-1person 当前的名字为: "+name);
		System.out.println("线程："+Thread.currentThread().getName()+"-2Person 当前的名字为: "+getName());
	}
	
	public void setName(String name) {
		this.name = name;
		threadLocal.set(name);
	};
	
	public String getName() {
		return threadLocal.get();
	}
}
