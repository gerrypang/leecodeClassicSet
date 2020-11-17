package com.gerry.queue;

/**
 * 基于数组实现顺序队列
 * 
 * @author pangguowei
 * @since 2020年11月6日
 */
public class BaseOnArrayQueue {
	private final int DEFAULT_CAPACITY = 8;
	private String[] items;
	private int length = 0;
	private int capacity;
	private int head, tail = 0;

	public BaseOnArrayQueue(int capacity) {
		super();
		this.capacity = capacity;
		items = new String[capacity];
	}

	public BaseOnArrayQueue() {
		super();
		this.capacity = DEFAULT_CAPACITY;
		items = new String[capacity];
	}
	
	public boolean enqueue(String data) {
		// tail 指向队尾
		if (tail == capacity) {
			// 存满了
			if (head == 0) {
				return false; 
			}
			// tail指向队尾，head前面还有空间，做一次整体向左搬移
			for (int i = head; i < tail; i++) {
				items[i-head] = items[i];
			}
			tail -= head;
			head = 0;
		}
		items[length] = data;
		tail++; 
		length++;
		return true;
	}
	
	public String dequeue() {
		if (tail == head) {
			return null;
		}
		String tmp = null;
		if (tail > head) {
			tmp = items[head];
			items[head] = null;
			head++;
			length--;
		}
		return tmp;
	}

	public int getLength() {
		return length;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}
	
	public static void main(String[] args) {
		BaseOnArrayQueue a = new BaseOnArrayQueue();
		a.enqueue("1");
		a.enqueue("11");
		a.enqueue("111");
		a.enqueue("1");
		a.enqueue("11");
		a.enqueue("111");
		a.enqueue("1");
		a.enqueue("11");
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue("111");
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		System.out.println();
	}

}
