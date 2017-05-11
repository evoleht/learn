package com.evoleht.algorithm.sumequal;


/**
 * 三边求和值相等
 * 					a1
 * 
 * 				a2		a3
 * 
 * 			a4				a4
 * 
 * 		a5		a6		a8		a9
 * 
 * 	将1~9个数字填入上图，每个数字能且只能使用一次，使得三条边的4个数字之和相等。
 * 
 */
public class ThreeEdgesSumEqual {
	static boolean used[] = new boolean[10];  
	static int array[] = new int[10];
	static int cnt = 0;
	
	public static void main(String[] args) {
		backtrack(1, 10);
	}
	
	public static boolean judge() {
		int sum1,sum2,sum3;
		sum1 = sum2 = sum3 = 0;
		for (int i = 1; i <=4; i++) {
			sum1 +=array[i];
		}
		for (int i = 4; i <=7; i++) {
			sum2 +=array[i];
		}
		for (int i = 7; i <=9; i++) {
			sum3 +=array[i];
		}
		  sum3 += array[1];  
		if (sum1 == sum2 && sum2 == sum3) {
			return true;
		}
		return false;
	}
	
	public static void backtrack(int k, int n) {
		if (k == n) {
			if (judge()) {
				cnt++;
				System.out.println("find one! cnt="+cnt );
				
				System.out.println("第一条边为："+ array[1]+"-"+ array[2]+"-"+ array[3]+"-"+ array[4]);
				System.out.println("第二条边为："+ array[4]+"-"+ array[5]+"-"+ array[6]+"-"+ array[7]);
				System.out.println("第三条边为："+ array[7]+"-"+ array[8]+"-"+ array[9]+"-"+ array[1]);
			}
			return;
		}
		
		for (int i = 1; i < n; i++) {
			if (!used[i]) {
				used[i] = true;
				array[k] = i;
				backtrack(k+1, n);
				used[i] = false;
			}
		}
	}
}
