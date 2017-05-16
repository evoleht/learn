package com.evoleht.algorithm.arr.only;

public class OnlyTest {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3,2,8,3,3,4,4,5,5};
		solution(arr);
	}
	
	public static void solution(int[] arr) {
		int num = arr[0];
		for (int i = 1; i < arr.length; i++) {
			num = num^arr[i];
		}
		System.out.println(num);
	}
}
