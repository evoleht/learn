package com.evoleht.algorithm.str.uppercase;

public class UpperCaseTest {
	
	public static void main(String[] args) {
		String str ="abDkd";
//		str.toUpperCase();
		System.out.println(upper(str));
		System.out.println(lower(str));
	}
	
	public static String upper(String str) {
		if(str == null || str.equals("")) return str;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 'a' && arr[i] <= 'z') {
				arr[i]=(char) (arr[i]-32);
			}
		}
		return new String(arr);
	}
	
	public static String lower(String str) {
		if(str == null || str.equals("")) return str;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 'A' && arr[i] <= 'Z') {
				arr[i] += 32;
			}
		}
		return new String(arr);
	}
}
