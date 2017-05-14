package com.evoleht.algorithm.sort;


/**
 * 快速排序。
 * 
 * 思路：从数列中挑出一个元素，称为“基准”
 *		重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *		在这个分割之后，
 *		该基准是它的最后位置。这个称为分割（partition）操作。
 *		递归的把小于基准值元素的子数列和大于基准值元素的子数列排序。 
 */

public class QuickSort {
	
	public static void main(String[] args) {
		int arr[] = {4,3,6,7,2,9,1,10,8};
		print(arr);
		sort(arr, 0, arr.length - 1);
		print(arr);
	}
	
	public static void sort(int arr[], int start, int end) {
		if(start >= end) return;
		//基准
		int base = arr[start];
		//搜索指针
		int i = start, j = end;
		//循环处理将小于基准的数放在左边，大于基准的放在右边
		while(i < j) {
			//后->前，查找小于基准的数
			while(i < j && arr[j] >= base) {
				j--;
			}
			//小于基准则交换
			if(i < j) {
				swap(arr, i, j);
			}
			//前->后， 查找大于基准的数
			while(i < j && arr[i] <= base) {
				i++;
			}
			//大于基准则交换
			if(i < j) {
				swap(arr, i, j);
			}
		}
		//递归处理左边的子序列
		sort(arr, start, i - 1);
		
		//递归处理右边的子序列
		sort(arr, i + 1, end);
		
	}
	
	public static void swap(int arr[], int i, int j) {
		//TODO 数值越界
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int arr[]) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("}");
	}
	
}
