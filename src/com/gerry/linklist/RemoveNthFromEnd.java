package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author pangguowei
 * @since 2020年10月30日 下午2:25:48
 */
public class RemoveNthFromEnd {

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
		// node5.next = node1;
		System.out.println(removeNthFromEnd(node1, 2));
	}

	/**
	 * 遍历
	 *
	 * @param head
	 * @param n
	 * @return
	 
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> coll = new ArrayList<>(10);
		ListNode idx = head;
		while (idx != null) {
			coll.add(idx);
			idx = idx.next;
		}
		// 哨兵节点
		ListNode sentry = new ListNode(-1);
		idx = sentry;
		idx.next = head;
		int num = 0;
		while (num < (coll.size() - n)) {
			idx = idx.next ;
			num++;
		}
		idx.next = idx.next.next;
		return sentry.next;
	}*/
	
	/**
	 * 双指针
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// 哨兵节点
		ListNode sentry = new ListNode(-1);
		sentry.next = head;
		ListNode fast = sentry.next;
		ListNode slow = sentry.next;
		int num = 1;
		while (fast != null) {
			fast = fast.next;
			num++;
			if (num > n) {
				slow = slow.next ;
			}
		}
		slow.next = slow.next.next;
		return sentry.next;
	}
}
