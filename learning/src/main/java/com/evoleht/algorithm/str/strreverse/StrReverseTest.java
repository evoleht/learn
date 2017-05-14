package com.evoleht.algorithm.str.strreverse;

import java.util.Arrays;

/**
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 */
public class StrReverseTest {
	
	public static void main(String[] args) {
		String str = "abcdef";
		int m = 2;
		str = reverse(str.toCharArray(), m);
		System.out.println(str);
		str = "abcdef";
		str = reverse1(str.toCharArray(), m);
		System.out.println(str);
	}
	
	public static String reverse(char[] arr, int m) {
		char temp;
		int len= arr.length;
		while(m >0 ) {
			temp = arr[0];
			for (int i = 0; i < len - 1; i++) {
				arr[i] = arr[i+1];
			}
			arr[len - 1] = temp;
			m--;
		}
		return new String(arr);
	}
	
	public static String reverse1(char[] arr, int m) {
		int end = arr.length - 1;
		reverseStr(arr, 0, m -1);
		reverseStr(arr, m, end);
		reverseStr(arr, 0, end);
		return new String(arr);
	}

	public static void reverseStr(char[] arr, int start, int end) {
		while(start < end) {
			char temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}
}
