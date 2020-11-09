package com.gerry.string;

/**
 * 125. 验证回文串<br/>
 * https://leetcode-cn.com/problems/valid-palindrome/<br/>
 * 
 * 输入: "A man, a plan, a canal: Panama" 输出: true
 * 输入: "race a car" 输出: false
 * @author pangguowei
 * @since 2020年11月2日 下午5:50:01
 */
public class IsPalindromeStr {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	/**
	 * 双指针
	 *
	 * @param s
	 * @return
	 * @author pangguowei
	 */
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] charArray = s.toCharArray();
		int x = 0;
		int y = charArray.length - 1;
		while (x < y) {
			while (isVaildChar(charArray[x]) == 0 && x < y) {
				x++;
			}
			while(isVaildChar(charArray[y]) == 0 && x < y) {
				y--;
			}
			if (isVaildChar(charArray[x]) != isVaildChar(charArray[y])) {
				return false;
			}
			x++;
			y--;
		}
		return true;
	}
	
	/**
	 * 双指针
	 *
	 * @param s
	 * @return
	 * @author pangguowei
	 
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] charArray = s.toCharArray();
		int x = 0;
		int y = charArray.length - 1;
		while (x < y) {
			while (isVaildChar(charArray[x]) == 0) {
				x++;
			}
			while(isVaildChar(charArray[y]) == 0) {
				y--;
			}
			if (isVaildChar(charArray[x]) != isVaildChar(charArray[y])) {
				return false;
			}
			x++;
			y--;
		}
		return true;
	}*/
	
	public static char isVaildChar(char one) {
		if (one >= 48 && one <= 57) {
			return one;
		}
		if (one >= 97 && one <= 122) {
			return (char) (one - 32);
		}
		if (one >= 65 && one <= 90) {
			return one;
		}
		return 0;
//		if (Character.isDigit(one)) {
//			return one;
//		}
//		if (Character.isAlphabetic(one)) {
//			return Character.toLowerCase(one);
//		}
//		return 0;
	}
}
