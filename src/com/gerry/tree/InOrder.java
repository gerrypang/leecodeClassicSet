package com.gerry.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.gerry.tree.common.TreeNode;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 
 * @author pangguowei
 * @since 2020年10月22日 上午11:17:49
 */
public class InOrder {

	public static void main(String[] args) {
		// [1,null,2,3]
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> orderList = inorderTraversal(root);
		System.out.println(orderList);
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> orderList = new ArrayList<>(10);
		return preOrder(root, orderList);
	}

	/**
	 * 递归方式
	 *
	 * @param root
	 * @param orderList
	 * @return
	 * @author pangguowei
	 * @since 2020年10月22日 上午10:43:39
	 */
//	private static List<Integer> preOrder(TreeNode root, List<Integer> orderList) {
//		if (root == null) {
//			return null;
//		}
//		preOrder(root.left, orderList);
//		orderList.add(root.val);
//		preOrder(root.right, orderList);
//		return orderList;
//	}

	/**
	 * 栈方式
	 *
	 * @param root
	 * @param orderList
	 * @return
	 * @author pangguowei
	 * @since 2020年10月22日 上午10:43:39
	 */
	private static List<Integer> preOrder(TreeNode root, List<Integer> orderList) {
		Deque<TreeNode> nodes = new LinkedList<>();
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			root = nodes.pop();
			orderList.add(root.val);
			root = root.right;
		}
		return orderList;
	}

}
