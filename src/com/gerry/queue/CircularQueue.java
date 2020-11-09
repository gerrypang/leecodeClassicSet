package com.gerry.queue;

/**
 * 循环队列
 * 
 * @author pangguowei
 * @since 2020年11月6日
 */
public class CircularQueue {
	private final int DEFAULT_CAPACITY = 5;
	private String[] items;
//	private int length = 0;
	private int capacity;
	private int head, tail = 0;
	
	public CircularQueue() {
		super();
		capacity = DEFAULT_CAPACITY;
		items = new String[capacity];
	}

	public CircularQueue(int capacity) {
		super();
		this.capacity = capacity;
		items = new String[capacity];
	}
	
	public boolean enqueue(String data) {
		if ((tail + 1) % capacity == head) {
			return false;
		}
		items[tail] = data;
		tail = (tail + 1) % capacity;
//		length++;
		return true;
	}

	public String dequeue() {
		if (head == tail) {
			return null;
		}
		String tmp = items[head];
		head = (head + 1) % capacity;
//		length--;
		return tmp;
	}
	
	public static void main(String[] args) {
		CircularQueue a = new CircularQueue();
		a.enqueue("1");
		a.enqueue("11");
		a.enqueue("111");
		a.enqueue("1");
		a.enqueue("11");
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue("0");
		a.enqueue("00");
		a.enqueue("000");
	}

}
