package com.evoleht.algorithm.sort.heapsort;

/**
 * 1.堆
 * 一颗完全二叉树，其中任何一个非叶子节点满足以下性质：
 * K[i] >=K[2i+1] && K[i] >=K[2i+2] 或者 K[i] <=K[2i+1] && K[i] <=K[2i+2]
 * 即任何一个非叶子节点关键字 不小于或者不大于其左右孩子节点的关键字。
 * 
 * 堆分为 大顶堆（大根堆）和小顶堆（小根堆）
 * 满足：K[i] >=K[2i+1] && K[i] >=K[2i+2] 的为 大顶堆（大根堆）
 * 满足：K[i] <=K[2i+1] && K[i] <=K[2i+2] 的为小顶堆
 * 
 * 大顶堆的堆顶的关键字 肯定是所有关键字中最大的，小顶堆的关键字肯定是所有关键字中最小的。
 * 
 * 2.堆排序思想
 * 利用大顶堆（小顶堆）堆顶记录的是最大关键字（最小关键字）这一特性，使得每次从无序中选择最大记录（最小记录）变得简单。
 * 
 * 基本思想（大顶堆）：
 * 1）将初始待排序关键字序列（R1,R2..Rn）构建成大顶堆，此堆为初始的无序区；
 * 2）将堆顶元素R1 与兑换一个元素 Rn交换，此时得到新的无序区（R1，R2....Rn-1）和新的有序区（Rn）且满足 R[1,2...n-1] <= R[n]
 * 3)由于交换后新的堆顶R1可能违反堆的性质，因此需要对当前的无序区（R1，R2...Rn-1）调整为新堆，然后再次将R1与无序区最后一个元素交换，得到
 * 新的无序区（R1，R2...Rn-2）和新的有序区（Rn-1，Rn）。不断重复此过程知道有序去元素个数为n-1，则整个排序过程完成
 *  
 * @author wangzs
 * @version v1.0.0
 * <p><B>last update </B> by wangzs @ 2017-4-2</p>
 * @since v1.0.0
 */
public class HeapSort {
	public static int[] data = {8,3,23,45,1,35,32,46,5,9,25};
	
	public static void main(String[] args) {
		//创建堆
		buildHeap(data);
		//排序
		sortHeap(data);
		//打印
		print(data);
	}
	
	/**
	 * 创建堆
	 */
	public static void buildHeap(int[] data) {
		//最后一个元素的父节点
		int parentIndex = getParentIndex(data.length -1);
		//最大堆
		for (int i = parentIndex; i >= 0; i--) {
			maxHeap(data, data.length, i);
		}
	}
	
	/**
	 * 调整堆
	 */
	public static void maxHeap(int[] data, int size, int index) {
		//左节点
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);
		//记录最大值索引
		int laster = index;
		
		if (left < size && data[index] < data[left]) {
			laster = left;
		}
		if (right < size && data[laster] < data[right]) {
			laster = right;
		}
		if (laster != index) {
			data = swap(data, index, laster);
			maxHeap(data, size, laster);
		}
	}
	
	/**
	 * 堆排序
	 */
	public static void sortHeap(int[] data) {
		for (int i = data.length -1 ; i>=0; i--) {
			data = swap(data, i, 0);
			maxHeap(data, i, 0);
		}
	}
	
	/**
	 * 打印
	 */
	public static void print(int[] data) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < data.length; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(data[i]);
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	/**
	 * 对于堆节点current 的父节点为 （current-1）/2
	 */
	public static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}
	
	/**
	 * 堆节点current 的左孩子为 current * 2 + 1;
	 */
	public static int getLeftChildIndex(int current) {
		return (current << 1) + 1;
	}
	
	/**
	 * 堆节点current 的左孩子为 current * 2 + 2;
	 */
	public static int getRightChildIndex(int current) {
		return (current << 1) +2;
	}
	
	/**
	 * 节点交换
	 */
	public static int[] swap(int data[], int index, int target) {
		int temp = data[index];
		data[index] = data[target];
		data[target] = temp;
		return data;
	}
}
