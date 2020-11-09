package com.gerry.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 
 * @author pangguowei
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		int target = 9;
		System.out.println(twoSum(nums, target));
	}
	
	// nums = [2, 7, 11, 15], target = 9
//	public static int[] twoSum(int[] nums, int target) {
//		int[] result = new int[2];
//		int sub = 0;
//		for (int i = 0; i < nums.length; i++) {
//			sub = target - nums[i];
//			for (int j = i; j < nums.length; j++) {
//				if (sub == nums[j]) {
//					result[0] = i;
//					result[1] = j;
//					return result;
//				}
//			}
//		}
//		return result;
//	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!sumMap.containsKey(nums[i])) {
				sumMap.put(nums[i], i);
			}
			int sub = target - nums[i];
			if (sumMap.containsKey(target - nums[i])) {
				result[0] = sumMap.get(sub);
				result[1] = i;
				break;
			}
		}
		return result;
	}
}
