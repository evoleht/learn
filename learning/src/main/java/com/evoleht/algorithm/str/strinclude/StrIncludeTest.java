package com.evoleht.algorithm.str.strinclude;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.regexp.internal.StringCharacterIterator;

/**
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。
 * 请问，如何最快地判断字符串B中所有字母是否都在字符串A里？

为了简单起见，我们规定输入的字符串只包含大写英文字母，
请实现函数bool StringContains(string &A, string &B)

比如，如果是下面两个字符串：

String 1：ABCD

String 2：BAD

答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。

如果是下面两个字符串：

String 1：ABCD

String 2：BCE

答案是false，因为字符串String2里的E字母不在字符串String1里。

同时，如果string1：ABCD，string 2：AA，同样返回true。
 *
 */
public class StrIncludeTest {
	
	public static void main(String[] args) {
		String a = "ABCD";
		String b = "BC";
		boolean flag = stringContains(a.toCharArray(), b.toCharArray());
		System.out.println(flag);
		
		flag = stringContains(a.toCharArray(), b.toCharArray());
		System.out.println(flag);
	}
	
	public static boolean stringContains(char arr[], char arr2[]) {
		for (int i = 0; i < arr2.length; i++) {
			int j;
			for (j = 0; j < arr.length && arr2[i] != arr[j]; j++)
				;
			if(j >= arr.length) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean stringContains1(char[] arr_a, char[] arr_b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arr_a.length; i++) {
			map.put(arr_a[i], 1);
		}
		for (int i = 0; i < arr_b.length; i++) {
			if(!map.containsKey(arr_b[i])){
				return false;
			}
		}
		return true;
	}

}
