package com.gerry.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static void main(String[] args) {

	}

	public static boolean containsDuplicate(int[] nums) {
		if (nums != null && nums.length == 1) {
			return false;
		}
		Set<Integer> a = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			a.add(nums[i]);
			if (a.size() == i) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

//	public static boolean containsDuplicate(int[] nums) {
//		if (nums != null && nums.length == 1) {
//			return false;
//		} 
//		Set<Integer> a = Arrays.stream(nums).mapToObj(n -> Integer.valueOf(n)).collect(Collectors.toSet());
//		if (a.size() == nums.length) {
//			return false;
//		} else {
//			return true;
//		}
//	}
}
