package com.evoleht.algorithm.str.strreverse;

/**
 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，
 * 但单词内字符的顺序不变，句子中单词以空格符隔开。为简单起见，
 * 标点符号和普通字母一样处理。
 * 例如，输入“I am a student.”，则输出“student. a am I”。
 *
 */
public class WordReverseTest {
	public static void main(String[] args) {
		String str = "I am a student.";
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length - 1);
		System.out.println(new String(arr));
		
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ') {
				reverse(arr, start, i-1);
				start = i+1;
			}
		}
		System.out.println(new String(arr));
	}
	
	public static void reverse(char[] arr, int start, int end) {
		while(start < end) {
			char temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}
}
