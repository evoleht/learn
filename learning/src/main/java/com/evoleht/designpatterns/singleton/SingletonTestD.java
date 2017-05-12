package com.evoleht.designpatterns.singleton;

public class SingletonTestD {
	private static SingletonTestD singletonTestD = null;
	
	private SingletonTestD() {
		
	}
	static {
		singletonTestD = new SingletonTestD();
	}
	public static SingletonTestD newInstance() {
		return singletonTestD;
	}
}
