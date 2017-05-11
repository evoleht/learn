package com.evoleht.algorithm;

import java.io.Serializable;

public class TreeNode implements Serializable{
	/**  **/
	private static final long serialVersionUID = 1L;
	public static int val;
	public static TreeNode left = null;
	public static TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}
