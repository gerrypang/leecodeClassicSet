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
		// 循环队列元素已满
		if ((tail + 1) % capacity == head) {
			return false;
		}
		// 元素加入到队尾
		items[tail] = data;
		// 移动队尾指针
		tail = (tail + 1) % capacity;
		return true;
	}

	public String dequeue() {
		// 队列空
		if (head == tail) {
			return null;
		}
		// 队头元素
		String tmp = items[head];
		// 移动队头指针
		head = (head + 1) % capacity;
		return tmp;
	}
	
	public static void main(String[] args) {
		// 缺点队列中会有一个元素空间被浪费
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
