package com.evoleht.algorithm.sort;

/**
 * 冒泡排序
 * 原理：
 * 设数组长度为N
 * 1.对数组相邻的两个元素进行比较，如果j > j+1 则交换。
 * 2.对数组第0个数据到N-1个数据的一次遍历可以将最大的一个数沉到第N-1的位置
 * 2.N=N-1，如果N！=0 则继续循环
 *  
 * @author wangzs
 * @version v1.0.0
 * @since v1.0.0
 */
public class BubbleSortTest {
	
	public int[] sort(int arr[]) {
		int[] result_arr = arr;
		int len = result_arr.length;
		System.out.println("一共有" + len + "个数据需要排序");
		for (int i = 0; i < result_arr.length; i++) {
			System.out.println("第" + (i+1) + "次冒泡排序");
			for (int j = 0; j < len-1; j++) {
				System.out.println("第" + (i+1) + "次冒泡排序,遍历第个" + (j+1) + "数据");
				if (result_arr[j] > result_arr[j+1]) {
					int tmp = result_arr[j];
					result_arr[j] = result_arr[j+1];
					result_arr[j+1] = tmp;
				}
			}
			len--;
		}
		return result_arr;
	}
	
	/**
	 * 改良版：
	 * 如果某一次遍历没有发生交换，我们可以认为剩下的数据已经是有序的
	 * 结束排序
	 */
	public int[] sortTwo(int target[]){
		int [] arr = target;
		int len = arr.length;
		System.out.println("一共有" + len + "个数据需要排序");
		boolean flag = true;
		while(flag) {
			System.out.println("第" + (arr.length + 1 - len) + "次冒泡排序");
			flag = false;
			for (int i = 1; i < len; i++) {
				System.out.println("第" + (arr.length + 1 - len) + "次冒泡排序,遍历第个" + i + "数据");
				if (arr[i-1] > arr[i]) {
					int tmp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = tmp;
					flag = true;
				}
			}
			len--;
		}
		return arr;
	}
	
	public int[] sortThree(int target[]) {
		int []arr = target;
		int len = arr.length;
		int k = len;
		while(k > 0) {
			for (int i = 0; i < k; i++) {
				
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,6,2,8,1,20,32,11};
		BubbleSortTest sortTest = new BubbleSortTest();
		int [] resunt = sortTest.sort(arr);
		for (int i = 0; i < resunt.length; i++) {
			System.out.print(resunt[i]+" ");
		}
		System.out.println();
		int arr1[] = {3,6,2,8,1,20,32,11};
		int [] resunt2 = sortTest.sortTwo(arr1);
		for (int i = 0; i < resunt2.length; i++) {
			System.out.print(resunt2[i]+" ");
		}
	}
}
