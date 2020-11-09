package com.gerry.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20.有效的括号<br/>
 * https://leetcode-cn.com/problems/valid-parentheses/<br/>
 * 输入: "([)]" 输出: false
 * 
 * @author pangguowei
 * @since 2020年11月2日 
 */
public class IsValidParentheses {
	
	public static void main(String[] args) {
		isValid("[)]");
	}
	
	public static Map<Character, Character> left = new HashMap<>(16);
		
	static {
		left.put('(', ')'); // (:40 ):41
		left.put('{', '}'); // {:123 }:125
		left.put('[', ']'); // [:91 ]:93
	}

	/**
	 * 栈方式
	 *
	 * @param str
	 * @return
	 */
	public static boolean isValid(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		char[] charArray = str.toCharArray();
		// 奇数个肯定是不成对
		if (charArray.length % 2 == 1) {
			return false;
		}
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < charArray.length; i++) {
			char n = charArray[i];
			if (left.containsKey(n)) {
				stack.push(n);
			} else {
				if (stack.isEmpty() || left.get(stack.peek()) != n) {
					return false;
				} else {
					stack.pop();
				}
			} 
		}
		return stack.isEmpty() ? true : false;
	}
}
