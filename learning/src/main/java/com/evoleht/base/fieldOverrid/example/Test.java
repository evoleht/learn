package com.evoleht.base.fieldOverrid.example;

public class Test {
	
	public static void main(String[] args) {
		Sub sub = new Sub();
		Super sub2 = new Sub();
		
		System.out.println(sub.field);
		System.out.println(sub2.field);
		
		System.out.println(((Super)sub).field);
	}
}
