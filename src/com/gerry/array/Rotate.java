package com.gerry.array;

public class Rotate {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		// 5 6 7 1 2 3 4  
		// 4 5 6 7 1 2 3     
		// 7 1 2 3 4 5 6
//
		int a = nums1.length / 2;
		int k1 = 1;
		rotate(nums1, k1);
//
//		int[] nums2 = { -1, -100, 3, 99 };
//		int k2 = 2;
//		rotate(nums2, k2);

//		int[] nums3 = { 1, 2, 3 };
//		int k3 = 4;
//		rotate(nums3, k3);
	}

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || nums.length == k) {
			return;
		}
		int first = 0;
		int tail = Math.abs(nums.length - k);
		int newK = tail;
		int x = 0;
		if (nums.length % 2 == 1) {
			first = nums[0];
			x = 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > newK || tail >= nums.length) {
				if (x == 1) {
					nums[newK] = first;
				}
				break;
			}
			int temp = nums[i + x];
			nums[i] = nums[tail];
			nums[tail] = temp;
			tail++;
		}
	}
}
