package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 21. 合并两个有序链表 
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * 
 * @author pangguowei
 * @since 2020年10月29日 上午10:03:14
 */
public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
//		ListNode l1_1 = new ListNode(2);
//		ListNode l1_2 = new ListNode(4);
//		l1.next = l1_1;
//		l1_1.next = l1_2;

		ListNode l2 = new ListNode(1);
		ListNode l2_1 = new ListNode(5);
//		ListNode l2_2 = new ListNode(5);
		l2.next = l2_1;
//		l2_1.next = l2_2;
		mergeTwoLists(l1, l2);

	}

	/**
	 * 遍历
	 *
	 * @param l1
	 * @param l2
	 * @return
	 
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 引入哨兵节点
		ListNode sentry = new ListNode(-1);
		ListNode idx = sentry;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				idx.next = l1;
				l1 = l1.next;
			} else {
				idx.next = l2;
				l2 = l2.next;
			}
			idx = idx.next; 
		}
		idx.next = l1 == null ? l2 : l1;
		return sentry.next;
	}*/
	
	/**
	 * 递归
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

}
