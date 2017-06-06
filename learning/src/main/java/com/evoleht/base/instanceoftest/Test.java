package com.evoleht.base.instanceoftest;

public class Test {
	
	public static void main(String[] args) {
		
		Sub subClass = new Sub();
		Super superClass = new Super();
		
		System.out.println(superClass instanceof Sub);
	}
}
