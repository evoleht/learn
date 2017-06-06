package com.evoleht.base.instanceoftest;

public class Test {
	
	public static void main(String[] args) {
		
		Sub subClass = new Sub();
		Super superClass = new Super();
		
		//子类可以是父类类型
		System.out.println(subClass instanceof Super);
		//父类不可以为子类类型
		System.out.println(superClass instanceof Sub);
		
		
	}
}
