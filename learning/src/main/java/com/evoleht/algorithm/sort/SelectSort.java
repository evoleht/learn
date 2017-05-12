package com.evoleht.algorithm.sort;

/**
 * 选择排序
 * 
 * 在未排序的序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾
 * 依次类推，直到所有元素均排序完毕
 * 
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int arr[] = {9,3,6,4,7,2,10,1};
		selectSortFirst(arr);
		printArr(arr);
	}
	
	public static void selectSortFirst(int arr[]) {
		int len = arr.length, temp;
		for (int i = 0; i < len; i++) {
			int k = i;
			for (int j = len -1; j > i; j--) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
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
