package com.evoleht.algorithm.arr.alternates;

public class AlternatesTest {
	
	public static void main(String[] args) {
		String[] arr = {"男","女","男","女","女","男","女","男","女"};
		solution(arr);
		print(arr);
	}
	
	public static void solution(String[] arr) {
		int len = arr.length - 1;
		for (int i = 0; i <= len; i++) {
			if (i%2 == 0) {
				if (arr[i].equals("男")) {
					continue;
				}else{
					int j;
					for (j = i+1; j <= len && arr[j].equals("男"); j++)
						if (j > len) break;
						else {
							String temp = arr[j];
							arr[j] = arr[i];
							arr[i] = temp;
						}
				}
			}else {
				if (arr[i].equals("女")) {
					continue;
				}else{
					int j;
					for (j = i+1; j <= len && arr[j].equals("女"); j++)
					if(j > len) break;
					else {
						String temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
	}
	
	public static void print(String[] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("}");
	}
}
