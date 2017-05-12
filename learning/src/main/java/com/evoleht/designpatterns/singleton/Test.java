package com.evoleht.designpatterns.singleton;

public class Test {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		ThreadTest t3 = new ThreadTest();
		
		t1.start();
		t2.start();
		t3.start();
	}
}
