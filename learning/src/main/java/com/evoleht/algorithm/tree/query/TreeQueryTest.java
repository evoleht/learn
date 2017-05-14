package com.evoleht.algorithm.tree.query;

public class TreeQueryTest {
	
	public static void main(String[] args) {
		int[] arr = {6,7,8,1,2,3,4,5};
		sort(arr, 0, arr.length -1);
		print(arr);
		query(arr, 0, arr.length - 1, 5);
		
	}
	
	public static void query(int[] arr, int start, int end, int m) {
		if(start <= end) {
			int mid = (start + end) >> 1;
			if(arr[mid] == m) {
				System.out.println("find! arr["+mid+"] = " +arr[mid]);
			}else if(arr[mid] > m) {
				query(arr, start, mid - 1, m);
			}else if(arr[mid] < m) {
				query(arr, mid + 1, end, m);
			}
		}
	}
	
	public static void sort(int arr[], int start, int end) {
		
		if(start >= end) return;
		int base = arr[start];
		int i = start, j = end;
		while(i < j) {
			while(i < j && arr[j] > base) {
				j--;
			}
			if(i < j) {
				swap(arr, i, j);
				i++;
			}
			while(i < j && arr[i] < base) {
				i++;
			}
			if(i < j) {
				swap(arr, i, j);
				j--;
			}
		}
		sort(arr, start, i-1);
		sort(arr, i+1, end);
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("}");
	}
}
