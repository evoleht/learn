package com.evoleht.algorithm.tree.buildtree;

import java.util.LinkedList;
import java.util.List;

import com.evoleht.algorithm.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *   
 *   思路：先序遍历，第一个肯定是根节点，定位根节点
 *   中序遍历，根节点左边的都是左子树，右边的都是右子树
 *   递归解决
 *   
链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
来源：牛客网

      先序遍历第一个位置肯定是根节点node，
  中序遍历的根节点位置在中间p，在p左边的肯定是node的左子树的中序数组，p右边的肯定是node的右子树的中序数组
  另一方面，先序遍历的第二个位置到p，也是node左子树的先序子数组，剩下p右边的就是node的右子树的先序子数组
  把四个数组找出来，分左右递归调用即可
 
*/
public class ReconstructBinaryTree {
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = recostructBinaryTree(pre, in);
		printTree(root);
	}
	
	public static TreeNode recostructBinaryTree(int[] pre, int[] in) {
		TreeNode root = recosTree(pre, 0, pre.length - 1, in, 0, in.length -1);
		return root;
	}
	
	public static TreeNode recosTree(int[] pre, int preStart, int preEnd,
			int[] in, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(pre[preStart]);
		for (int i = inStart; i <= inEnd; i++) {
			if (pre[preStart] == in[i]) {
				node.left = recosTree(pre, preStart+1,preStart+ i - inStart, in, inStart, i-1);
				node.right = recosTree(pre, preStart - inStart +i+1, preEnd, in, i+1, inEnd);
			}
		}
		return node;
	}
	
	public static void printTree(TreeNode root) {
		if (root == null) {
			System.out.println("树为null!");
		}
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.offer(root);
		TreeNode node;
		while (!list.isEmpty()) {
			node = list.poll();
			System.out.print(node.val);;
			if (node.left != null) {
				list.offer(node.left);
			}
			if (node.right != null) {
				list.offer(node.right);
			}
		}
		
	}
}
