package com.evoleht.designpatterns.singleton;

public class ThreadTest extends Thread{
	@Override
	public void run() {
		super.run();
//		System.out.println(SingletonTest.newInstance().hashCode());
//		System.out.println(SingletonTestA.newInstance().hashCode());
//		System.out.println(SingletonTestB.newInstance().hashCode());
//		System.out.println(SingletonTestC.newInstance().hashCode());
		System.out.println(SingletonTestD.newInstance().hashCode());
	}
}
