package com.evoleht.algorithm.linkedlist;

import com.evoleht.algorithm.ListNode;
import com.evoleht.algorithm.TreeNode;

/**
 * 单链表查找倒数第K个数
 *
 */
public class FindKNodeFromTail {
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		find(root, 8);
		
	}
	
	public static ListNode find(ListNode root, int k) {
		int i =0, j = 0;
		ListNode node = root;
		while(node != null) {
			node = node.next;
			i++;
			if(i >= k) {
				j++;
			}
		}
		System.out.println(j);
		return null;
	}
}
