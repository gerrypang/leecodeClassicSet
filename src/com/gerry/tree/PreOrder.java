package com.gerry.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.gerry.tree.common.TreeNode;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 
 * @author pangguowei
 * @since 2020年10月22日 上午11:18:38
 */
public class PreOrder {

	public static void main(String[] args) {
		// [1,null,2,3]
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> orderList = preorderTraversal(root);
		System.out.println(orderList);
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> orderList = new ArrayList<>(10);
		return preOrder(root, orderList);
	}

	/**
	 * 栈方式
	 *
	 * @param root
	 * @param orderList
	 * @return
	 * @author pangguowei
	 * @since 2020年10月22日 上午11:32:44
	 */
	private static List<Integer> preOrder(TreeNode root, List<Integer> orderList) {
		Deque<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.push(root);
        }
		while (!nodes.isEmpty()) {
			root = nodes.pop();
            orderList.add(root.val);
            // right先入栈，后出栈
			if (root.right != null) {
				nodes.push(root.right);
			}
			if (root.left != null) {
				nodes.push(root.left);
			}
		}
		return orderList;
	}

	/**
	 * 递归方式
	 *
	 * @param root
	 * @param orderList
	 * @return
	 * @author pangguowei
	 * @since 2020年10月22日 上午11:32:15
	 */
//	private static List<Integer> preOrder(TreeNode root, List<Integer> orderList) {
//		if (root == null) {
//			return orderList;
//		}
//		orderList.add(root.val);
//		preOrder(root.left, orderList);
//		preOrder(root.right, orderList);
//		return orderList;
//	}
}
