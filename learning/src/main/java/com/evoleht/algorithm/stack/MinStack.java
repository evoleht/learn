package com.evoleht.algorithm.stack;

import java.util.Stack;

/**
 *  Design a stack that supports push, pop, top, 
 *  and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class MinStack {
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(4);
		stack.push(7);
		stack.push(5);
		System.out.println(stack.getMin());
	}
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		if(minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
	}
	
	public int pop() {
		if(stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		return stack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
}