package com.evoleht.algorithm.linkedlist;

import java.util.Stack;

import com.evoleht.algorithm.ListNode;

public class LinkedReverse {
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
		
		solution(p);
	}
	
	public static void solution(ListNode node) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode n = node;
		while(n != null) {
			stack.push(n);
			n = n.next;
		}
		
		ListNode root = null,newNode =null;
		if(!stack.isEmpty()) {
			root = stack.pop();
		}
		n = root;
		while(!stack.isEmpty()) {
			newNode = stack.pop();
			newNode.next = null;
			n.next = newNode;
			n = newNode;
		}
		
		while(root != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}
}
 