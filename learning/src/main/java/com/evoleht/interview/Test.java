package com.evoleht.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test {
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("key", "value");
		map.put("key1", "value1");
		
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getValue());
		}
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		
		treeMap.put("key", "value");
		treeMap.put("key1", "value1");
	}
}
