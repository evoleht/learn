package com.evoleht.designpatterns.singleton;

public class SingletonTest {
	
	public static volatile SingletonTest  singletonTest= null;
	
	private SingletonTest() {
	}

	synchronized public static SingletonTest newInstance() {
		try {
			if (singletonTest == null) {
				Thread.sleep(3000);
				singletonTest = new SingletonTest(); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return singletonTest;
	}
}
