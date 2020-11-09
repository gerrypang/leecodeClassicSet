package com.gerry.tree;

import com.gerry.tree.common.TreeNode;

/**
 * 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 
 * @author pangguowei
 * @since 2020年10月23日 下午2:36:47
 */
public class IsValidBST {

	public static void main(String[] args) {
		// [5,1,4,null,null,3,6]
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		return validBST(root);
	}

	private static boolean validBST(TreeNode root) {
		if (root!= null && root.val < root.left.val) {
			return false;
		} 
		if (root!= null && root.val > root.right.val) {
			return false;
		} 
		return validBST(root.left) && validBST(root.right);
	}
	
	
}
