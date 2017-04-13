package com.evoleht.thread.threadpool.ThreadLocal;

public class Worker extends Thread{
	
	String name;
	Person person;
	Worker(Person person, String name) {
		this.person = person;
		this.name = name;
	}
	
	@Override
	public void run() {
		this.person.setName(this.name);
		this.person.print();
	}
}
