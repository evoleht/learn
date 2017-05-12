package com.evoleht.algorithm.sort;


/**
 * 插入排序
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移动到下一个位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置中
 * 6.重复步骤2
 * 
 */
public class InsertSort {
	public static void main(String[] args) {
		int arr[] = {9,3,6,4,7,2,10,1};
		insertSortFirst(arr);
		printArr(arr);
	}
	
	public static void insertSortFirst(int arr[]) {
		int len = arr.length, temp, j;
		for (int i = 1; i < len; i++) {
			temp = arr[i];
			for (j = i; j >0 && arr[j-1] > temp; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	
	public static void printArr(int arr[]) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.print("}");
		System.out.println();
	}
}









