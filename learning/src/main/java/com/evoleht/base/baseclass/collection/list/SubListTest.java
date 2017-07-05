package com.evoleht.base.baseclass.collection.list;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {

	public static void main(String[] args) {
		final int cacheMaxRoom = 5;
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("22");
		list.add("333");
		list.add("444");
		list.add("555");
		list.add("666");
		
		list = list.subList(0, cacheMaxRoom);
		
		printList(list);
	}
	
	static void printList(List<String> list) {
		for(String str : list) {
			System.out.println(str);
		}
	}
}
