package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * @author pangguowei
 * @since 2020年10月26日 下午2:14:12
 */
public class ReverseList {

	public static void main(String[] args) {
		// 1->2->3->4->5->NULL
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		reverseList(node1);
	}

	/**
	 * 双指针，遍历方式
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 * @since 2020年10月26日 下午2:53:12
	 
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = pre; 
			pre = cur; 
			cur = temp;
		}
		return pre;
	}*/

	/**
	 * 递归方式
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 * @since 2020年10月26日 下午2:59:29
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}
}
