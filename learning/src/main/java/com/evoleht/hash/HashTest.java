package com.evoleht.hash;

import java.util.HashSet;


public class HashTest {

	public static void main(String[] args) {
		
//		for (int i = 0; i < 1000; i++) {
//			String r = "test"+i;
//			System.out.println(r.hashCode());
//			System.out.println( Math.abs(r.hashCode()) % 10);
//		}
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(abs(Integer.MIN_VALUE));
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(1);
		set.add(2);
	}
	
	public static long abs(long a) {
		return a<0 ? -a : a;
	}
}
