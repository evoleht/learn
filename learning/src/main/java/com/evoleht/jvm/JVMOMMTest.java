package com.evoleht.jvm;

import java.util.ArrayList;
import java.util.List;

public class JVMOMMTest {
	
	public static void main(String[] args) {
		List<MyObject> list = new ArrayList<MyObject>();
		while (true) {
			MyObject object = new MyObject();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			list.add(object);
		}
	}
}
