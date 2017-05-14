package com.evoleht.algorithm.str.strsort;


/**
 * 一个字母组成的字符串，对该字符串字母序进行排序，大写在小写前面
 *
 */
public class StrSortTest {
	
	public static void main(String[] args) {
		String str = "BAmMCcmwdNDbWa";
		char[] arr = str.toCharArray();
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(new String(arr));
	}
	
	public static void mergeSort(char[] arr,int start, int end) {
		if(start < end) {
			int mid = (start + end) >> 1;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, end, mid);
		}
	}
	
	public static void merge(char[] arr, int start, int end, int mid) {
		if(start < end) {
			char[] temp = new char[end - start + 1];
			int i = start, j = mid+1, k=0; 
			char m,n;
			while(i <= mid && j <= end) {
				m = arr[i];
				n = arr[j];
				if(arr[i] >='a' && arr[i] <= 'z') {
					m = (char) (arr[i] - 32);
				}
				if(arr[j] >= 'a' && arr[j] <= 'z') {
					n = (char) (arr[j] - 32);
				}
				if(m < n) {
					temp[k++] = arr[i++];
				}else if(m == n){
					if(arr[i] >='a' && arr[i] <= 'z') {
						temp[k++] = arr[i++];
					}else {
						temp[k++] = arr[j++];
					}
				}else {
					temp[k++] = arr[j++];
				}
			}
			while (i <= mid) {
				temp[k++] = arr[i++];
			}
			while (j <= end) {
				temp[k++] = arr[j++];
			}
			for (int d = 0; d < temp.length; d++) {
				arr[start + d] = temp[d];
			}
		}
	}
}
