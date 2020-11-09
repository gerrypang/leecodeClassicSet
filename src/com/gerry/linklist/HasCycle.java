package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 141. 环形链表 
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *  
 * [test1] 输入：head = [3,2,0,-4], pos = 1 输出：true
 * [test2] 输入：head = [1], pos = -1 输出：false
 * 
 * @author pangguowei
 * @since 2020年10月30日 上午10:00:32
 */
public class HasCycle {

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
//		node5.next = node1;
		System.out.println(hasCycle(node1));
	}

	/**
	 * set集合法
	 *
	 * @param head
	 * @return
	 
	public static boolean hasCycle(ListNode head) {
		Set<ListNode> coll = new HashSet<>(16);
		while (head != null) {
			if (!coll.add(head)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}*/

	/**
	 * 快慢指针
	 *
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head; 
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
