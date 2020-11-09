package com.gerry.string;

/**
 * 字符串转换整数 (atoi)
 * 
 * @author pangguowei
 * @since 2019年12月9日 下午5:36:08
 */
public class MyAtoi {
	
    public static int myAtoi(String str) {
    	if (str == null || str.trim().length() == 0) {
    		return 0;
    	}
    	String s = str.trim();
    	
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;
        
        char firstChar = s.charAt(0);
        if (firstChar == '-') {
            negative = true;
            limit = Integer.MIN_VALUE;
            i++;
		} else if (firstChar == '+') {
			i++;
		}
		multmin = limit / 10;
		while (i < len) {
			digit = Character.digit(s.charAt(i++), 10);
			str.charAt(0);
			if (digit < 0) {
				break;
			}
			if (result < multmin) {
				result = limit;
				break;
			}
			result *= 10;
			if (result < limit + digit) {
				result = limit;
				negative = false;
				break;
			}
			result -= digit;
		}
		return negative ? result : -result;
    }
    
    public static void main(String[] args) {
//    	
//    	int a1 = myAtoi("   -42");
//    	System.out.println(a1);
//    	
//    	int a2 = myAtoi("4193 with words");
//    	System.out.println(a2);
//    	
//    	int a3 = myAtoi("words and 987");
//    	System.out.println(a3);
//    	
//    	int a4 = myAtoi("-91283472332");
//    	System.out.println(a4);
//
//    	int a5 = myAtoi("2147483648");
//    	System.out.println(a5);
    	
    	
    	String aa = "106,,,,,108";
    	String[] ab = aa.split(",");
    	System.out.println();
	}
}
