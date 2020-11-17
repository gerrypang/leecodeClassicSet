package com.gerry.queue;

/**
 * 基于链表实现链式队列
 * 
 * @author pangguowei
 * @since 2020年11月17日
 */
public class BaseOnLinkedListQueue {
	
	private int count;
	private Node head;
	private Node tail;
	
	public BaseOnLinkedListQueue() {
		super();
		count = 0;
		// 哨兵节点
		head = new Node();
		tail = head;
	}
	
	public void enqueue(String value) {
		tail.next = new Node(value, null);
		tail = tail.next;
		count += 1;
	}
	
	public String dequeue() {
		if (head.next == null) {
			tail = head;
			return null;
		}
		Node tmp = head.next;
		if (head.next != null) {
			head.next = head.next.next;
		}
		count -= 1;
		return tmp.value;
	}
	
	public int size() {
		return count;
	}
	
	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}

	public class Node {
		private String value;
		private Node next;
		
		public Node() {
			super();
		}

		public Node(String value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}

		public String getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}
	}

	public static void main(String[] args) {
		BaseOnLinkedListQueue a = new BaseOnLinkedListQueue();
		a.enqueue("1");
		a.enqueue("11");
		a.enqueue("111");
		a.enqueue("1");
		a.enqueue("11");
		a.printAll(); 
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.printAll(); 
		a.enqueue("0");
		a.enqueue("00");
		a.enqueue("000");
		a.printAll(); 
		System.out.println(a.size());
	}

}
