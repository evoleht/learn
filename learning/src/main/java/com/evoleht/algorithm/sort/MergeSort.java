package com.evoleht.algorithm.sort;

/**
 * 归并排序
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4.重复步骤3直到某一指针达到序列尾
 * 5.将另一序列剩下的所以元素直接复制到合并序列列尾
 * 
 */
public class MergeSort {
	
	public static void main(String[] args) {
		int arr[] = {9,3,6,4,7,2,10,1};
		printArr(arr);
		sort(arr, 0, arr.length-1);
		printArr(arr);
	}
	
	public static void sort(int arr[], int low, int high) {
		int mid = (high + low) / 2;
		if (low < high) {
			sort(arr, low, mid);
			sort(arr, mid +1, high);
			merge(arr, low, mid, high);
		}
	}
	
	public static void merge(int arr[], int low, int mid, int high) {
		int temp[] = new int[high - low + 1];
		int i=low, j=mid+1, k=0;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		//
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		
		for (int m=0; m < temp.length; m++) {
			arr[m+low] = temp[m];
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
