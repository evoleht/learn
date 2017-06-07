package com.evoleht.base.baseclass.concurrents.atomicbooleantest;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {
	
	public static void main(String[] args) {
		AtomicBoolean ab = new AtomicBoolean(false);
		
		System.out.println(ab.compareAndSet(false, true));
	}
}
