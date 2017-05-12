package com.evoleht.designpatterns.singleton;

public class SingletonTestB {
	
	public static SingletonTestB  singletonTest= null;
	
	private SingletonTestB() {
	}

	public static SingletonTestB newInstance() {
		try {
			if (singletonTest == null) {
				Thread.sleep(3000);
				synchronized(SingletonTestB.class) {
					if (singletonTest == null) {
						singletonTest = new SingletonTestB();
					}
				}
			}
		} catch (Exception e) {
		}
		return singletonTest;
	}
}
