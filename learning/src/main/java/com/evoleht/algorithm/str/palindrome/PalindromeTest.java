package com.evoleht.algorithm.str.palindrome;

/**
 * 
 * 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，
 * 这样的短句在智力性、趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 * 那么，我们的第一个问题就是：判断一个字串是否是回文？
 *
 */
public class PalindromeTest {

	public static void main(String[] args) {
		String str = "madam";
		System.out.println(judge(str));
	}
	
	public static boolean judge(String str) {
		if(str == null || (str.trim()).equals("")) {
			return false;
		}
		char[] arr = str.toCharArray();
		int i=0, j=arr.length -1;
		for (; i<j; i++, j--) {
			if(arr[i] != arr[j]){
				return false;
			}
		}
		return true;
	}
}
