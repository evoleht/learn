package com.evoleht.algorithm.numcomputer;


public class Fibonacci {
	
	public static void main(String[] args) {
		int n = 39;
		System.out.println(solution(6));
	}
	
	public static int solution(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		int a = 0, b = 1,num = 0;
		for (int i = 2; i <=n; i++) {
			num = a + b;
			a = b;
			b = num;
		}
		return num;
	}
}
