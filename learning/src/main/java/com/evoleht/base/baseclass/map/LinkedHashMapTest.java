package com.evoleht.base.baseclass.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapTest {
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("1", "1");
		map.put("5", "5");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
	}
}
