package com.evoleht.algorithm.remove;

/**  
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次
 * 并且返回新的数组的长度
 * 
 *  不要使用额外的数组空间，必须在原地没有额外空间的条件下完成
 */
public class RemoveDuplicatesTest {
	
	public int remove(int []arr) {
		int len = arr.length;
		int j = 1;
		if(len == 0) {
			return 0;
		}
		for (int i = 1; i < len; i++) {
			if(arr[i] == arr[i-1]) {
				continue;
			}else {
				arr[j] = arr[i];
				j++;
			}
		}
		return j;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,2};
		RemoveDuplicatesTest t = new RemoveDuplicatesTest();
		int i = t.remove(arr);
		System.out.println(i);
		
	}
}
