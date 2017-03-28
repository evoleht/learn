package com.evoleht.algorithm;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 * 
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2017-3-3</p>
 * @since v1.0.0
 */
public class TestQuery {
	
	 /**
	 * 直接双层循环查找
	 */
	public boolean find(int target, int [][] array) {
		for (int i = 0; i < array.length; i++) {
			int [] arr = array[i];
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == target) {
					return true;
				}
			}
		}
		return false;
	 }
	 
	 /**
	 * 利用给定条件，数组横向递增，纵向递增。
	 * 选取数组左下角数据为起始比较值，小于target 则 j++
	 * 大于target，则i--
	 */
	public boolean find2(int target, int[][] array) {
		 int i=array.length-1,j=0;
		 while(i>=0 && j <= array[0].length-1) {
			 if(array[i][j] < target) {
				 j++;
			 }else if(array[i][j] > target){
				i--;
			}else {
				return true;
			}
		 }
		 return false;
	 }
	 
	 public static void main(String[] args) {
		int target = 0;
		int[][] arr = {{1,3,5,7},
					   {2,4,6,8},
					   {9,10,11,12}};
		
		TestQuery tq = new TestQuery();
		boolean flag = tq.find(target, arr);
		System.out.println(flag);
		
		boolean flag2 = tq.find2(target, arr);
		System.out.println(flag2);
		
	}
}
