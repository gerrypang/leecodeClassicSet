package com.gerry.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.gerry.tree.common.TreeNode;

/**
 * 145. 二叉树的后序遍历
 * 
 * @author pangguowei
 * @since 2020年10月22日 上午11:30:56
 */
public class PostOrder {

	public static void main(String[] args) {
		// [1,null,2,3]
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> orderList = postorderTraversal(root);
		System.out.println(orderList);
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> orderList = new ArrayList<>(10);
		return postOrder(root, orderList);
	}

	/**
	 * 递归方法
	 *
	 * @param root
	 * @param orderList
	 * @return
	 * @author pangguowei
	 * @since 2020年10月22日 下午2:31:35
	 */
//	public static List<Integer> postOrder(TreeNode root, List<Integer> orderList) {
//		if (root == null) {
//			return orderList;
//		}
//		postOrder(root.left, orderList);
//		postOrder(root.right, orderList);
//		orderList.add(root.val);
//		return orderList;
//	}
	
	public static List<Integer> postOrder(TreeNode root, List<Integer> orderList) {
		Deque<TreeNode> nodes = new LinkedList<>();
		TreeNode prev = null; 
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			root = nodes.pop();
			if (root.right == null || root.right == prev) {
				orderList.add(root.val);
				prev = root;
                root = null;
			} else {
				nodes.push(root);
				root = root.right;
			}
		}
		return orderList;
	}
}
