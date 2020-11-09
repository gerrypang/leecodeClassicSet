package com.gerry.stack;

/**
 * 155. 最小栈<br/> 
 * https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 输入：
	["MinStack","push","push","push","getMin","pop","top","getMin"]
	[[],[-2],[0],[-3],[],[],[],[]]
	
	输出：
	[null,null,null,null,-3,null,0,-2]
 * 
 * @author pangguowei
 * @since 2020年11月6日
 */
public class MinStack {
	/** initialize your data structure here. */
	private Integer[] stack;
	private Integer[] minStack;
	private final static int MAX_SIZE = 10480;
	private int length;
	private int minLength;
	
	public MinStack() {
		stack = new Integer[MAX_SIZE];
		minStack = new Integer[MAX_SIZE];
		minStack[minLength] = Integer.MAX_VALUE;
		length = 0;
		minLength = 1;
	}

	/**
	 * push(x) —— 将元素 x 推入栈中。
	 */
	public void push(int x) {
		stack[length] = x;
		if (minStack[minLength-1] > x) {
			minStack[minLength] = x;
		} else {
			minStack[minLength] = minStack[minLength-1];
		}
		length++;
		minLength++;
	}

	/**
	 * pop() —— 删除栈顶的元素。
	 */
	public void pop() {
		stack[length - 1] = null;
		minStack[minLength - 1] = null;
		length--;
		minLength--;
	}

	/**
	 * top() —— 获取栈顶元素。
	 */
	public int top() {
		return stack[length - 1];
	}

	/**
	 * getMin() —— 检索栈中的最小元素
	 */
	public int getMin() {
		return minStack[minLength - 1];
	}
	
	public static void main(String[] args) {
		// ["MinStack","push","push","push","getMin","pop","top","getMin"]
		// [[],[-2],[0],[-3],[],[],[],[]]
		MinStack a = new MinStack();
		a.push(-10);
		a.push(14);
		a.push(-20);
		a.pop();
		a.push(10);
		a.push(7);
		System.out.println(a.getMin());
		a.pop();
		a.pop();
		System.out.println(a.getMin());
		a.pop();
		// System.out.println(a.top());
	}
}
