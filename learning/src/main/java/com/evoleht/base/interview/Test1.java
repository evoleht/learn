package com.evoleht.base.interview;

public class Test1 {
	
	public static void main(String[] args) {
		/**
		 *	两个变量 int a = 5， int b = 6;
		 * 
		 *  在不引入新的变量的时候，如何将a，b 交换
		 *  
		 */
		
		int a = 5;
		int b = 6;
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a= " + a);
		System.out.println("b= " + b);
	}
}
