package com.gerry.array;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] num1 = { 1, 0, 1 };
		moveZeroes(num1);
		int[] num2 = { 0, 1, 0, 3, 12 };
		moveZeroes(num2);
		System.out.println();
	}

	// 0, 1 , 0, 3, 12
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int x = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[x] == 0) {
				if (nums[i] == 0) {
					continue;
				}
				nums[x] = nums[i];
				nums[i] = 0;
				x++;
			} else {
				x++;
			}
		}
	}

}
