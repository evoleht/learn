package com.evoleht.base.concept;

import java.util.HashSet;
import java.util.Set;

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
