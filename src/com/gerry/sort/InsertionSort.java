package com.gerry.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 
 * @author pangguowei
 * @since 2020年11月17日 
 */
public class InsertionSort {

	public static void main(String[] args) {
		// 4, 5, 6, 3, 2, 1
		// 1, 2, 3, 4, 5, 6
		int[] arr = { 4, 5, 6, 3, 2, 1 };
		insertionSort(arr);
	}
	
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int n = arr.length;
		
		// 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
		for (int i = 1; i < n; i++) {
			// 记录要插入的数据
			int value = arr[i];
			// 前一位数据下标
			int j = i - 1;
			// 查找要插入的位置并移动数据
			for (; j >= 0; j--) {
				if (arr[j] > value) {
					// 前一位赋值给后一位，即向后移动
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = value;
		}
		System.out.println(Arrays.toString(arr));
	}
}
