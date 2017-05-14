package com.evoleht.algorithm;

import java.io.Serializable;

public class TreeNode implements Serializable{
	/**  **/
	private static final long serialVersionUID = 1L;
	public int val;
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}
