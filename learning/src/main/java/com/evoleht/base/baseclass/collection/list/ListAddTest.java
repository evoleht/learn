package com.evoleht.base.baseclass.collection.list;

import java.util.Arrays;


public class ListAddTest {
	
	public static void main(String[] args) {
		/**
		 * List add(index, E)
		 * 将数据插入到 list的指定位置,原数数据依次往后挪一个位置
		 */
		ArrayListTest<String> list = new ArrayListTest<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add(0,"7");
		
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
		/**
		 * System.arraycpopy
		 * System.arraycopy(src, srcPos, dest, destPos, length)
		 * 参数说明：
		 * src 原数组
		 * srcPos 原数组的其实位置
		 * dest 目标数组
		 * destPos 目标数组的其实位置
		 * length 复制的长度
		 * 
		 * 将原数组从起始位置开始的length个元素 复制到 目标数组destPost开始的length个位置
		 */
		
		String[] str = {"1","2","3","4","5","6"};
		int num = str.length;
		str = Arrays.copyOf(str, num + 1);
		int index = 1;
		System.arraycopy(str, index, str, index + 1, num-index);
		System.out.print("{ ");
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+",");
		}
		System.out.print(" }");
		
	}
}
