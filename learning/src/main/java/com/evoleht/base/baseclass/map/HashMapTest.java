package com.evoleht.base.baseclass.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		Hashtable<String, String> table = new Hashtable<String, String>();
		
		String str = null;
		System.out.println(str.hashCode());
//		table.put(null, "");
		
		Collections.synchronizedMap(map);
	}
}
