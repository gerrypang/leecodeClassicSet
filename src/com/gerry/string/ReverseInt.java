package com.gerry.string;

/**
 * 整数反转
 * 
 * @author pangguowei
 * @since 2019年12月9日 下午5:36:42
 */
public class ReverseInt {
	public static int reverse(int x) {
		if (x == 0) {
            return x;
        }
		try {
			StringBuilder s = new StringBuilder(12);
			if (x > 0) {
				return Integer.valueOf(s.append(x).reverse() + "");
			} else {
				return -1 * Integer.valueOf(s.append(x * -1).reverse() + "");
			}
		} catch (NumberFormatException e) {
			return 0;
		} 
     }
	
	public static void main(String[] args) {
		int a1 = -123;
		a1 = reverse(a1);
		System.out.println(a1);
		
		int a2 = 123;
		a2 = reverse(a2);
		System.out.println(a2);
		
		int a3 = -3;
		a3 = reverse(a3);
		System.out.println(a3);
		
	}
}
