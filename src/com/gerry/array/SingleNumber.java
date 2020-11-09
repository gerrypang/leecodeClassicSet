package com.gerry.array;

/**
 * 136. 只出现一次的数字
 * 
 * @author pangguowei
 */
public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(nums));
	}
	
	// 4,1,2,1,2
//	public static int singleNumber(int[] nums) {
//		int index = 0;
//		int maxIndex = nums.length - 1;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[index] == nums[i] && index < i) {
//				nums[index] = 0;
//				nums[i] = 0;
//				index++;
//				i = index; 
//			}
//			if (nums[index] == 0) {
//				index = index + 1 > maxIndex ? maxIndex : index + 1;
//			}
//		return nums[index];
//	}

	public static int singleNumber(int[] nums) {
		int index = 0 ;
		for(int a : nums){
			index ^=  a;
        }
		return index;
	}
}
