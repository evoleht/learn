package com.evoleht.algorithm.tree.binarytree;

import java.util.LinkedList;

import com.evoleht.algorithm.TreeNode;

/**
 * 有序数组转化为二叉树
 * 给定一个有序数组，数组元素升序排列，试将数组转换为一颗平衡二叉搜索树。
 * 
 * 
 * 思路： 递归
 * 所谓平衡的定义，就是指二叉树的子树高度之差不能超过1
 * 
 * 链接：https://www.nowcoder.com/questionTerminal/7e5b00f94b254da599a9472fe5ab283d
 * 
	本题的解题主要采用分治+递归实现 
  	因为所给数组为有序数组，题目要求得到一棵平衡二叉树 
  1.得到数组中间位置元素，此元素即为平衡查找树的根节点root 
  2.然后递归调用函数让数组前半段、后半段也为平衡查找树 
  3.root的左右子树分别为步骤2得到平衡查找树的根节点 
  4.返回root节点即为最后构建好的平衡二叉树 
 * 
 */
public class ArrayToBinaryTree {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		TreeNode node = sortToBST(arr, 0, arr.length -1);
		System.out.println("层次遍历----------");
		print(node);
		System.out.println("先序遍历---------");
		preorder(node);
		System.out.println("中序遍历------------");
		inorder(node);
		System.out.println("后序遍历-------------");
		postorder(node);
	}
	
    public static TreeNode  sortToBST(int arr[], int start, int end) {
		if (arr == null ) {
			return null;
		}
		if (start > end) {
			return null;
		}
		int mid = end - (end - start)/2;
		
		TreeNode node = new TreeNode(0);
		
		node.val = arr[mid];
		node.left = sortToBST(arr, start, mid-1);
		node.right = sortToBST(arr, mid + 1, end);
		return node;
	}
	
    
    /**
     * 层次遍历
     */
    public static void print(TreeNode root) {
    	LinkedList<TreeNode> list = null;
    	if(root != null) {
    		list = new LinkedList<TreeNode>();
    		list.offer(root);
    		while(!list.isEmpty()){
    			TreeNode node = list.poll();
    			printVal(node);
    			if(node.left != null) {
    				list.offer(node.left);
    			}
    			if(node.right !=null) {
    				list.offer(node.right);
    			}
    		}
    	}
    }
    
    /**
     *  先序遍历
     */
    public static void preorder(TreeNode node) {
    	if(node != null) {
    		printVal(node);
    		preorder(node.left);
    		preorder(node.right);
    	}
    }
    
    /**
     * 中序遍历
     */
    public static void inorder(TreeNode node) {
    	if(node != null) {
    		inorder(node.left);
    		printVal(node);
    		inorder(node.right);
    	}
    }
    
    /**
     * 后序遍历
     */
    public static void postorder(TreeNode node) {
    	if(node != null) {
    		postorder(node.left);
    		postorder(node.right);
    		printVal(node);
    	}
    }
    
    public static void printVal(TreeNode node) {
    	if(node != null) {
    		System.out.println(node.val);
    	}
    }
}
