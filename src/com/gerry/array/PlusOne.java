package com.gerry.array;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		int[] nums = { 9, 9 };
		plusOne(nums);
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length-1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				break;
			} else {
				digits[i] = 0;
			}
			if (i == 0) {
				int[] newScores = (int[]) Arrays.copyOf(digits, digits.length + 1);
				newScores[0] = 1;
				return newScores;
			}
		}
		return digits;
	}
}
