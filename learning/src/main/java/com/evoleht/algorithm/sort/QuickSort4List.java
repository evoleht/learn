package com.evoleht.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.evoleht.util.StopWatchUtil;

/**
 * 基于list的快速排序。
 * 
 * 思路：从数列中挑出一个元素，称为“基准”
 *		重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *		在这个分割之后，
 *		该基准是它的最后位置。这个称为分割（partition）操作。
 *		递归的把小于基准值元素的子数列和大于基准值元素的子数列排序。 
 */

public class QuickSort4List {
	
	public static void main(String[] args) {
		//初始化数据
		List<DistanceObj> list = new ArrayList<DistanceObj>();
		for (int i = 0; i < 10000; i++) {
			DistanceObj obj = new DistanceObj();
			obj.setName("room_"+i);
			obj.setDistance(i+1);
			list.add(obj);
		}
		//数据乱序
		Collections.shuffle(list);
		//Collections compareTo
		List<DistanceObj> list2 = new ArrayList<DistanceObj>();
		list2.addAll(list);
		
		//quick sort
		StopWatchUtil watch = new StopWatchUtil();
		watch.start();
		sort(list, 0, list.size() - 1);
		watch.end();
		print(list);
		watch.printEclapseDetai();
		
		//Collections sort
		watch.clear();
		watch.start();
		Collections.sort(list2);
		watch.end();
		watch.printEclapseDetai();
	}
	
	public static void sort(List<DistanceObj> list, int start, int end) {
		if(start >= end) return;
		//基准
		DistanceObj base = list.get(start);
		//搜索指针
		int i = start, j = end;
		//循环处理将小于基准的数放在左边，大于基准的放在右边
		while(i < j) {
			//后->前，查找小于基准的数
			while(i < j && compare(list.get(j), base)) {
				j--;
			}
			//小于基准则交换
			if(i < j) {
				swap(list, i, j);
			}
			//前->后， 查找大于基准的数
			while(i < j && !compare(list.get(i), base)) {
				i++;
			}
			//大于基准则交换
			if(i < j) {
				swap(list, i, j);
			}
		}
		//递归处理左边的子序列
		sort(list, start, i - 1);
		//递归处理右边的子序列
		sort(list, i + 1, end);
	}
	
	public static boolean compare(DistanceObj obj, DistanceObj target) {
		if(obj ==null || target == null) return false;
		if(obj.getDistance() > target.getDistance()) {
			return true;
		}
		return false;
	}
	
	public static void swap(List<DistanceObj> list, int i, int j) {
		//TODO 数值越界
		DistanceObj temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static void print(List<DistanceObj> list) {
		System.out.print("{");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			DistanceObj obj = list.get(i);
			System.out.print(obj.getName()+"----"+obj.getDistance()+";  ");
			if(i  % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("}");
	}
	
}
