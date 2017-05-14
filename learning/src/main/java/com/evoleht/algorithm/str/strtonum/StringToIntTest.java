package com.evoleht.algorithm.str.strtonum;

/**
 * 输入一个由数字组成的字符串，
 * 把它转换成整数并输出。例如：输入字符串"123"，输出整数123。

	给定函数原型int StrToInt(const char *str) ，
	实现字符串转换成整数的功能，不能使用库函数atoi。
 *
 */
public class StringToIntTest {
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str);
	}
	
	public static int strToInt(String str) {
		if(str == null || (str.trim()).equals("")) {
			return 0;
		}
		char[] arr = str.toCharArray();
		int i = 0;
		while(arr[i] == ' ') {
			i++;
		}
		
		int len = str.length();
		int num = 0;
		for (; i < len; i++) {
			 num = num *10 + (arr[i] - '0');
		}
		return num;
	}
}
