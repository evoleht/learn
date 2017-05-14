package com.evoleht.algorithm.other;

/**
 * 求2的N次方
 *
 */
public class MathCompute {
	
	public static void main(String[] args) {
		int r = 2;
		int n = 7;
		
		System.out.println(computer(r, n));
	}
	
	public static long computer(int r, int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		return r*computer(r,n-1);
	}
}
