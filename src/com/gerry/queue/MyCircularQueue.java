package com.gerry.queue;

/**
 * 622.设计一个循环队列<br/>
 * https://leetcode-cn.com/problems/design-circular-queue/
 * 
 * @author pangguowei
 * @since 2020年11月16日 
 */
class MyCircularQueue {

	private int[] elements;
	private int capacity, count;
	private int head, tail;
	
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
		this.capacity = k;
		elements = new int[capacity];
		head = 0;
		tail = 0;
		count = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if (isFull()) {
    		return false;
    	}
    	tail = (head + count) % capacity; // 重点
		elements[tail] = value;
		count += 1;
		return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		// 清除
		elements[head] = -1; 
		head = (head + 1) % capacity; // 重点
		count -= 1;
		return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if (isEmpty()) {
    		return -1;
    	}
    	return elements[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if (isEmpty()) {
    		return -1;
    	}
    	int tailIndex = (head + count - 1) % capacity; // 重点
    	return elements[tailIndex];
    }
    
	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return this.count == capacity;
	}
	
	/**
	 * Your MyCircularQueue object will be instantiated and called as such:
	 * MyCircularQueue obj = new MyCircularQueue(k);
	 * boolean param_1 = obj.enQueue(value);
	 * boolean param_2 = obj.deQueue();
	 * int param_3 = obj.Front();
	 * int param_4 = obj.Rear();
	 * boolean param_5 = obj.isEmpty();
	 * boolean param_6 = obj.isFull();
	 */
	public static void main(String[] args) {
		MyCircularQueue obj = new MyCircularQueue(5);
		boolean param_1 = obj.enQueue(1);
		int param_041 = obj.Rear();
		boolean param_2 = obj.enQueue(2);
		boolean param_3 = obj.enQueue(2);
		boolean param_4 = obj.enQueue(2);
		boolean param_01 = obj.deQueue();
		boolean param_02 = obj.deQueue();
		boolean param_5 = obj.enQueue(2);
		boolean param_6 = obj.enQueue(0);

		int param_03 = obj.Front();
		int param_04 = obj.Rear();
		boolean param_05 = obj.isEmpty();
		boolean param_06 = obj.isFull();
	}

}
