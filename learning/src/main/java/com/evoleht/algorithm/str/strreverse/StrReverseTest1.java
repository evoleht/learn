package com.evoleht.algorithm.str.strreverse;

/**
 * 2、编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，
 * 要求：长度为n的字符串操作时间复杂度为O(n)，空间复杂度为O(1)。 
 * 例如，原字符串为”Ilovebaofeng”，m=7，输出结果为：”baofengIlove”。
 *
 */
public class StrReverseTest1 {
	
	public static void main(String[] args) {
		String str = "Ilovebaofeng";
		int m = 7;
		char[] arr = str.toCharArray();
		rightReverseStr(arr, m);
		System.out.println(new String(arr));
		
		arr = str.toCharArray();
		rightReverseStr1(arr, m);
		System.out.println(new String(arr));
		
	}
	
	public static void rightReverseStr(char[] arr, int m) {
		int end = arr.length - 1;
		char temp;
		while(m > 0) {
			temp = arr[end];
			for (int i = end; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp; 
			m--;
		}
	}
	
	public static void rightReverseStr1(char[] arr, int m) {
		int start = 0, 
			end = arr.length - 1, 
			mid = end - m;
		reverseStr(arr, start, mid);
		reverseStr(arr, mid+1, end);
		reverseStr(arr, start, end);
	}
	
	public static void reverseStr(char[] arr, int start, int end) {
		while(start < end) {
			char temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}
}
