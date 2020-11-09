package com.gerry.string;

import java.util.Arrays;

/**
 * 反转字符串
 * 
 * @author pangguowei
 * @since 2019年12月9日 下午5:36:08
 */
public class ReverseString {
	
    public static void reverseString(char[] s) {
		if (s != null) {
			if (s.length > 1) {
				int end = s.length - 1;
				for (int i = 0; i < s.length / 2; i++) {
					char temp = s[i];
					s[i] = s[end];
					s[end] = temp;
					end -= 1;
				}
			}
		} else {

			return;
		}
    }
    
    public static void main(String[] args) {
		char[] a = { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(a);
		System.out.println(Arrays.toString(a));
		char[] b = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(b);
		System.out.println(Arrays.toString(b));
	}
}
