package com.evoleht.algorithm.arr.query;

import java.util.TreeMap;

public class NumQuery {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,4,4,1,5,6,1,1,1,1,1,1,2,2};
		queryNum1(arr);
		System.out.println(queryNum(arr, 0, arr.length - 1));
	}
	
	public static int queryNum(int[] arr, int start, int end) {
		int i = start, j = end;
		int num = arr[i], count = 1;
		for (i = i+1; i<j; i++) {
			if (arr[i] == num) {
				count++;
			}else {
				count--;
			}
			if (count == 0 ) {
				num = arr[i];
				count = 1;
			}
		}
		return num;
	}
	
	public static int queryNum1(int[] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		Integer key = map.firstKey();
		int num = map.get(key);
		if (num > (arr.length>>1)) {
			System.out.println(key);
			System.out.println(num);
		}
		
		return 0;
	}
}
