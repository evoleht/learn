package com.evoleht.algorithm.sort;


/**
 * 快速排序。
 * 
 * 思路：从数列中挑出一个元素，称为“基准”
 *		重新排序数列，所以元素比基准值小的摆放在基准前面，所以元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *		在这个分割之后，
 *		该基准是它的最后位置。这个称为分割（partition）操作。
 *		递归的把小于基准值元素的子数列和大于基准值元素的子数列排序。 
 */

public class QuickSort {
	
	public static void main(String[] args) {
		int arr[] = {11,1,9,3,4,2,10,43,2,35,36};
		printArr(arr);
		quickSortFirst(arr, 0, arr.length-1);
		printArr(arr);
	}
	
	
	
	public static void  quickSortFirst(int arr[], int start, int end) {
		if (start < end) {
			int base = arr[start];
			int temp;
			int i = start, j = end;
			
			do {
				while ((arr[i] < base) && (i < end)) {
					i++;
				}
				while ((arr[j] > base) && (j > start)) {
					j--;
				}
				if (i<=j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
					printArr(arr);
				}
			} while (i <=j);
			printArr(arr);
			System.out.println("i="+i+",j="+j);
			if (start < j) {
				quickSortFirst(arr, start, j);
			}
			if (end > i) {
				quickSortFirst(arr, i, end);
			}
		}
	}
	
	public static void quickSortTwo(int arr[], int low, int hight) {
		if (low > hight) {
			return;
		}
		int i=low, j = hight, index = arr[i];
		
		
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
