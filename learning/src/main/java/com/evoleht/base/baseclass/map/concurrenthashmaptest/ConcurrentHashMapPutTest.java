package com.evoleht.base.baseclass.map.concurrenthashmaptest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHashMapPutTest {
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	public static void test1() {
		System.out.println("test1-----");
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		//put-if-absent add success return null
		System.out.println(map.putIfAbsent("test", "test"));
		//put-if-exist  add fail return exist value
		System.out.println(map.putIfAbsent("test", "test2"));
		System.out.println(map.get("test"));
	}
	
	public static void test2() {
		System.out.println("test2-----");
		ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();
		AtomicLong ac = map.get("test");
		if(ac == null) {
			ac = new AtomicLong();
			map.putIfAbsent("test", ac);
		}
		
		while(true) {
			Long c = ac.get();
			if(ac.compareAndSet(c, c+1)) {
				break;
			}
		}
		
		System.out.println("map value is :" + map.get("test"));
		System.out.println("ac value is :" +ac.get());
	}
	
	public static void test3() {
		System.out.println("test3-----");
		ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();
		AtomicLong  acNew;
		AtomicLong ac = map.get("test");
		if(ac == null) {
			ac = new AtomicLong();
			//模拟
			acNew = new AtomicLong();
			map.putIfAbsent("test", acNew);
		
			map.putIfAbsent("test", ac);
		}
		
		while(true) {
			Long c = ac.get();
			if(ac.compareAndSet(c, c+1)) {
				break;
			}
		}
		
		System.out.println("map value is :" + map.get("test"));
		System.out.println("ac value is :" +ac.get());
	}
	
	public static void test4() {
		System.out.println("test4------");
		ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();
		AtomicLong  acNew;
		AtomicLong ac = map.get("test");
		if(ac == null) {
			ac = new AtomicLong();
			//模拟
			acNew = new AtomicLong();
			map.putIfAbsent("test", acNew);
		
			AtomicLong v = map.putIfAbsent("test", ac);
			if(v != null) {
				ac = v;
			}
		}
		
		while(true) {
			Long c = ac.get();
			if(ac.compareAndSet(c, c+1)) {
				break;
			}
		}
		
		System.out.println("map value is :" + map.get("test"));
		System.out.println("ac value is :" +ac.get());
	}
}
