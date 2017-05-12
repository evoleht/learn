package com.evoleht.designpatterns.singleton;

public class SingletonTestA {
	//立即加载 饿汉模式
	public static SingletonTestA singletonTestA = new SingletonTestA();

	private SingletonTestA() {
	}

	public static SingletonTestA newInstance() {
		return singletonTestA;
	}
}
