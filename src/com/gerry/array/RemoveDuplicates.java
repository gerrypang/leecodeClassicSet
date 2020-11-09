package com.gerry.array;

/**
 * 26. 删除排序数组中的重复项
 * 
 * @author pangguowei
 */
public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index;
	}
}
