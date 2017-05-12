package com.evoleht.designpatterns.singleton;

public class SingletonTestC {
	
	private static class SingletonHandl {
		private static SingletonTestC singletonTestC = new SingletonTestC();
	}
	
	private SingletonTestC() {}
	
	public static SingletonTestC newInstance() {
		return SingletonHandl.singletonTestC;
	}
}
