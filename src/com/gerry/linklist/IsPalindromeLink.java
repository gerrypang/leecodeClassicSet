package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 234. 回文链表<br/>
 * https://leetcode-cn.com/problems/palindrome-linked-list/<br/>
 * 
 * @author pangguowei
 * @since 2020年11月2日 下午5:54:42
 */
public class IsPalindromeLink {

	public static void main(String[] args) {
		// 1->2->3->4->5->NULL
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
//		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;
		System.out.println(isPalindrome(node1));
		System.out.println();
	}

	/**
	 * 数组+双指针
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	
	public static boolean isPalindrome(ListNode head) {
		List<ListNode> tmp = new ArrayList<>(10);
		while (head != null) {
			tmp.add(head);
			head = head.next;
		}	
		int start = 0;
		int last = tmp.size() - 1;
		
		while(start < last) {
			if (tmp.get(start).val != tmp.get(last).val) {
				return false;
			}
			start++;
			last--;
		}
		return true;
	} */
	
	/**
	 * 递归
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	
	private static ListNode front;
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
            return true;
        }
		front = head;
		return recursivelyCheck(head);
	}

	private static boolean recursivelyCheck(ListNode cur) {
		if (cur != null) {
			// 这个判断设计很好
			if (!recursivelyCheck(cur.next)) {
				return false;
			}
			if (front.val != cur.val) {
				return false;
			}
			front = front.next;
		}
		return true;
	} */

	/**
	 * 快慢指针
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
            return true;
        }
		// 找到中间结点
		ListNode first = head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// 从中节点开始反转列表
		ListNode reLink = reverstLink(slow);
		ListNode tmp = reLink;
		while (tmp != null) {
			if (first.val != tmp.val) {
				reverstLink(reLink);
				return false;
			}
			first = first.next;
			tmp = tmp.next;
		}
		reverstLink(reLink);
		return true;
	}
	
	
	public static ListNode reverstLink(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		ListNode tmp = head;
		while (cur != null) {
			tmp = tmp.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	 
}
