package com.evoleht.base.mathabs;

public class MathAbsTest {
	
	//http://blog.csdn.net/arkblue/article/details/18008981
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(abs(Integer.MIN_VALUE));
	}
	
	public static long abs(long a) {
		return a<0 ? -a : a;
	}
}
