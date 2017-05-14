package com.evoleht.algorithm.tree.subtree;

import java.util.LinkedList;

import com.evoleht.algorithm.TreeNode;

/**
 * 判读一棵树是否是另一颗树的子树
 * 
 * 树 A：       4
 *		3    5
 *	  1  2	6  7
 *
 * 树B ：      3
 * 		 1   2
 */
public class SubTreeTest {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(4);
		TreeNode root_1 = new TreeNode(1);
		TreeNode root_2 = new TreeNode(2);
		TreeNode root_3 = new TreeNode(3);
		TreeNode root_5 = new TreeNode(5);
		TreeNode root_6 = new TreeNode(6);
		TreeNode root_7 = new TreeNode(7);
		a.left = root_3;
		a.right = root_5;
		
		root_3.left = root_1;
		root_3.right = root_2;
		
		root_5.left = root_6;
		root_5.right = root_7;
		
		
		TreeNode b = new TreeNode(3);
		TreeNode root_b1 = new TreeNode(1);
		TreeNode root_b2 = new TreeNode(2);
		
		b.left = root_b1;
		b.right = root_b2;
		
		System.out.println(subTree(a, b));
	}
	
	public static boolean subTree(TreeNode treeA, TreeNode treeB) {
		//同为null true
		if(treeA == null && treeB == null) {
			return true;
		}
		//只有A 为null false
		if(treeA == null) {
			return false;
		}
		//只有B 为null false
		if(treeB == null) {
			return true;
		}
		//队列
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		//将A根节点压入队列
		list.offer(treeA);
		
		//层次遍历A树，在A树中找出与B根节点相同的节点
		TreeNode node;
		while(!list.isEmpty()) {
			node = list.poll();
			if(judge(node,treeB)){
				return true;
			}
			if(node.left != null) {
				list.offer(node.left);
			}
			if(node.right != null) {
				list.offer(node.right);
			}
		}
		return false;
	}
	
	
	public static boolean judge(TreeNode treeA, TreeNode treeB) {
		//同为null true
		if(treeA == null && treeB == null) {
			return true;
		}
		//只有A 为null false
		if(treeA == null) {
			return false;
		}
		//只有B 为null false
		if(treeB == null) {
			return true;
		}
		if(treeA.val == treeB.val) {
			return judge(treeA.left, treeB.left) && judge(treeA.right, treeB.right); 
		}
		return false;
	}
	
	
	
	
}
