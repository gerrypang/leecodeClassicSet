package com.gerry.linklist;

import com.gerry.linklist.common.ListNode;

/**
 * 876. 链表的中间结点 
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 
 * @author pangguowei
 * @since 2020年10月26日 下午3:34:06
 */
public class MiddleNode {
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
		middleNode(node1);
	}

	/**
	 * 数组存储法
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 * @since 2020年10月26日 下午3:49:41
	
	public static ListNode middleNode(ListNode head) {
		List<ListNode> arr = new ArrayList<>(10);
		while (head != null) {
			arr.add(head);
			head = head.next;
		}
		return arr.get(arr.size()/2);
	} */
	
	/**
	 * 单指针法
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 * @since 2020年10月26日 下午3:52:41
	 
	public static ListNode middleNode(ListNode head) {
		int num = 0;
		ListNode tmp = head;
		// 遍历全部节点，获取节点总数
		while (tmp != null) {
			num ++;
			tmp = tmp.next;
		}
		int mid = 0;
		// 第二次遍历一半个数节点
		while (mid < num / 2) {
			mid ++;
			head = head.next;
		}
		return head;
	}*/
	
	
	/**
	 * 快慢指针方法
	 *
	 * @param head
	 * @return
	 * @author pangguowei
	 * @since 2020年10月26日 下午4:09:16
	 */
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			// 快指针，+2
			fast = fast.next.next;
			// 慢指针，+1
			slow = slow.next;
		}
		return slow;
	}
}
