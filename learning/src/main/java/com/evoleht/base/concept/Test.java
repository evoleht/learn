package com.evoleht.base.concept;

import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		int a = 4;
		int b = 4;
		Integer aa = a;
		Integer bb = b;
		
		System.out.println(aa.equals(bb));
		
		HashSet<Object> set = new HashSet<Object>();
		set.add("");
	}
}
