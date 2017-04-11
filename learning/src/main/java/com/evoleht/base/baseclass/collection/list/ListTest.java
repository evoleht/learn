package com.evoleht.base.baseclass.collection.list;

import java.util.ArrayList;

import com.evoleht.util.StopWatchUtil;

public class ListTest {
	static ArrayList<String> listA = new ArrayList<String>();
	static ArrayList<String> listB = new ArrayList<String>();
	static int MAX_SIZE = 5000000;
	/*static String[] strArr = new String[MAX_SIZE];
	static String[] strArr1 = new String[10];*/
	public static void main(String[] args) {
		
		/*int millis = 2;
		
		StopWatchUtil stopWatchC = new StopWatchUtil("CTask");
		stopWatchC.start();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < MAX_SIZE; i++) {
			long start1 = System.currentTimeMillis();
			strArr[i] = "vv"+i;
			long end = System.currentTimeMillis();
			if ((end - start1) > millis) {
				System.out.println("单个添加耗时超过"+millis+"毫秒的有第"+i+"个,添加耗时："+(end - start1));
			}
		}
		stopWatchC.end();
		stopWatchC.printEclapseDetai();
		System.out.println("-------------------------");
		StopWatchUtil stopWatchD = new StopWatchUtil("DTask");
		stopWatchD.start();
		
		
		for (int i = 0; i < MAX_SIZE; i++) {
			int a1 = strArr1.length;
			int size = i + 1;
			if (size > a1) {
				int newCapacity = (a1 * 3)/2 + 1;
				 if (newCapacity < size)
						newCapacity = size;
				 strArr1 = Arrays.copyOf(strArr1, newCapacity);
			}
			long start1 = System.currentTimeMillis();
			strArr1[i] = "vv1"+i;
			long end = System.currentTimeMillis();
			if ((end - start1) > millis) {
				System.out.println("单个添加耗时超过"+millis+"毫秒的有第"+i+"个,添加耗时："+(end - start1));
			}
		}
		
		stopWatchD.end();
		stopWatchD.printEclapseDetai();*/
		StopWatchUtil stopWatchA = new StopWatchUtil("未初始化 ATask");
		stopWatchA.start();
		for (int i = 0; i < MAX_SIZE; i++) {
			listA.add("v"+i);
		}
		stopWatchA.end();
		stopWatchA.printEclapseDetai();
		
		StopWatchUtil stopWatchB = new StopWatchUtil("初始化 BTask");
		listB.ensureCapacity(MAX_SIZE);
		stopWatchB.start();
		for (int i = 0; i < MAX_SIZE; i++) {
			listB.add("v"+i);
		}
		stopWatchB.end();
		stopWatchB.printEclapseDetai();
		
		
	}
}
