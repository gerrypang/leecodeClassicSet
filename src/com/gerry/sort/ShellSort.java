package com.gerry.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 
 * @author pangguowei
 * @since 2020年11月20日 下午4:51:22
 */
public class ShellSort {

	public static void main(String[] args) {
		// 4, 5, 6, 3, 2, 1
		// 1, 2, 3, 4, 5, 6
		int[] arr = { 4, 5, 6, 3, 2, 1 };
		shellSort(arr);
	}
	
	public static void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		
		int n = arr.length;
		int step = n / 2;
		while (step >= 1) {
			
			for (int i = step; i < n; i++) {
				int value = arr[i];
				int j = i - step;
				
				for (; j >= 0; j -= step) {
					if (arr[j] > value) {
						arr[j + step] = arr[j];
					} else {
						break;
					}
				}
				arr[j + step] = value;
			}
			
			step = step / 2;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
