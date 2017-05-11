package com.evoleht.algorithm.str;

public class StringReverseTest {

	
	/**
	 *  StringBuffer reverse();
	 */
	public String stringReverse(String str) {
		return new StringBuffer(str).reverse().toString();
	}
	
	/**
	 * 遍历
	 */
	public String stringReverseA(String str) {
		char[] chars = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = chars.length-1; i >=0 ; i--) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}
	
	/**
	 * 交换
	 */
	public String stringReverseB(String str) {
		char[] chars = str.toCharArray();
		int len = chars.length-1;
		int halfLen = len/2;
		for (int i = 0; i <= halfLen; i++,len--) {
			char temp = chars[i];
			chars[i] = chars[len];
			chars[len] = temp;
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		StringReverseTest test = new StringReverseTest();
		String str = "java str reverse";
		System.out.println(test.stringReverse(str));
		System.out.println(test.stringReverseA(str));
		System.out.println(test.stringReverseB(str));
	}
}
