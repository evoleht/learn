package com.evoleht.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 *  输入一个链表，从尾到头打印链表每个节点的值。  
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class Solution {
	/**方法一*/
	/*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode p = listNode;
		query(list, p);
        return list;
    }
	
	public void query(ArrayList<Integer> list, ListNode n) {
		if (n != null) {
			query(list, n.next);
			list.add(n.val);
		}
	}*/
	
	/** 方法二
	 *  运行时间：32ms
		占用内存：629k
	 *  */
	/*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		ListNode p = listNode;
		while (p!= null) {
			stack.push(p.val);
			p = p.next;
		}
		while (stack.size() > 0) {
			list.add(stack.pop());
			
		}
        return list;
    }*/
	
	/**方法三
	 * 运行时间：34ms
		占用内存：654k
	 * */
	
	/*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  ListNode p = listNode;
		  while (p != null) {
			  list.add(p.val);
			  p = p.next;
		  }
		  Collections.reverse(list);
		  return list;
	}*/
	
	/**方法四*/
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  ListNode p = listNode;
		  while (p != null) {
			  list.add(0,p.val);
			  p = p.next;
		  }
		  return list;
	} 
	
	public static void main(String[] args) {
		ListNode p = new ListNode(0);
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		p.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		Solution s = new Solution();
		s.printListFromTailToHead(p);
	}
}
