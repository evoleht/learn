package com.evoleht.base.classextends.extend2;

public class Bar {
	
	public void test(ClassA a) {
		a.func();
		System.out.println("test A in Bar");
	}
	
	public void test(ClassC c) {
		c.func();
		System.out.println("test C in Bar");
	}
	
	public static void main(String[] args) {
		Bar bar = new Bar();
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		ClassC c = new ClassC();
		bar.test(a);
		bar.test(b);
		bar.test(c);
	}
}
