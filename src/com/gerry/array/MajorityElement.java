package com.gerry.array;

import java.util.Arrays;

/**
 * 169. 多数元素 
 * https://leetcode-cn.com/problems/majority-element 
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 输入: [2,2,1,1,1,2,2] 输出: 2
 * 
 * @author pangguowei
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}

	/**
	 * 哈希表
	 *
	 * @param nums
	 * @return
	 * @author pangguowei
	 
	public static int majorityElement(int[] nums) {
		int majority = 0;
		if (nums == null) {
			return majority;
		}
		Map<Integer, Integer> maps = new HashMap<>(16);
		for (int i = 0; i < nums.length; i++) {
			if (maps.containsKey(nums[i])) {
				maps.put(nums[i], maps.get(nums[i]) + 1);
			} else {
				maps.put(nums[i], 1);
			}
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
			if (entry.getValue() > max) {
				majority = entry.getKey();
				max = entry.getValue();
			}
		}
		return majority;
	}*/
	
	
	/**
	 * 排序法
	 *
	 * @param nums
	 * @return
	 * @author pangguowei
	 */
	public static int majorityElement(int[] nums) {
		// 排序
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}












