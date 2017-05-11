package com.evoleht.algorithm.str;

public class ReverseTest {
	
	public static void main(String[] args) {
		System.out.println(Math.sqrt(13));
		System.out.println(sqrt(13));
	}
	
	
	public static int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (long)(low + high) / 2;
            if (mid * mid == x) {
                return (int)mid;
            }else if (mid * mid > x) {
                high = (int)mid - 1;
            }else {
                low = (int)mid + 1;
            }  
        }
        return high;
    }
}
