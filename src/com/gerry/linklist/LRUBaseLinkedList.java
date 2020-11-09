package com.gerry.linklist;

import java.util.Scanner;

/**
 * 如何基于链表实现 LRU 缓存淘汰算法
 * 
 * @author pangguowei
 * @since 2020年11月5日
 */
public class LRUBaseLinkedList<T> {
	
	private final static int DEFAULT_CAPACITY = 10;
	private Node<T> head;
	private int length;
	private int capacity;
	
	public LRUBaseLinkedList() {
		super();
		// 哨兵节点
		this.head = new Node<>();
		this.capacity = DEFAULT_CAPACITY;
		this.length = 0;
	}
	
	public LRUBaseLinkedList(int capacity) {
		super();
		// 哨兵节点
		this.head = new Node<>();
		this.capacity = capacity;
		this.length = 0;
	}
	
	public void add(T data) {
		// 遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部
		Node<T> tmp = findPreNode(data);
		if (tmp != null) {
			deleteOptim(tmp);
			insertAtBegin(data);
		} else {
			if (length >= capacity) {
				// 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
				deleteAtEnd();
			}  
			// 如果此时缓存未满，则将此结点直接插入到链表的头部
			insertAtBegin(data);
		}
	}
	
	/**
	 * 获取查找到元素的前一个结点
	 *
	 * @param data
	 * @return
	 */
	public Node<T> findPreNode(T data) {
		Node<T> preNode = head; // 易错点
		while (preNode.next != null) {
			if (data.equals(preNode.next.element)) {
				return preNode;
			}
			preNode = preNode.next;
		}
		return null;
	}
	
	private void insertAtBegin(T data) {
		Node<T> preNode = head.getNext();
		head.setNext(new Node<T>(data, preNode));
		length++;
	}
	
	public void deleteAtEnd() {
		Node<T> preNode = head; // 易错点
		// empty list
		if (preNode.next == null) {
			return;
		}
		// 倒数第二个结点
		while (preNode.next.next != null) { // 易错点
			preNode = preNode.next;
		}
		// 尾节点
		Node<T> tail = preNode.next; 
		preNode.setNext(null);
		tail = null;
		length--;
	}

	private void deleteOptim(Node<T> preNode) {
		Node<T> tmp = preNode.next;
		preNode.setNext(tmp.next);
		tmp = null;
		length--;
	}

	public void printAll() {
		Node<T> preNode = head.next; 
		while(preNode != null) {
			System.out.print(preNode.element + ", ");
			preNode = preNode.next;
		}
		System.out.println();
	}

	/**
	 * 链表节点
	 * 
	 * @param <T>
	 */
	public class Node<T> {
		private T element;
		private Node<T> next;
		
		public Node() {
			super();
		}

		public Node(T element, Node<T> next) {
			super();
			this.element = element;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		LRUBaseLinkedList<String> list = new LRUBaseLinkedList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			list.add(sc.next());
			list.printAll();
		}
	}
	
}
