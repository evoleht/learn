package com.evoleht.base.baseclass.collection.array;

public class IntArrayTest {

	public static void main(String[] args) {
		int[] int1 = {1,2};
		int[] int2 = {2,3};
		countRoomAndPlayerNum(int1, int2);
		System.out.println(int1[0]+"---"+int1[1]);
	}
	
	
	static void countRoomAndPlayerNum(int[] int1, int[] int2) {
		int1[0] += int2[0];
		int1[1] += int2[1];
	}
}
