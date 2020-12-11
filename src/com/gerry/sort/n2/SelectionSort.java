package com.gerry.sort.n2;

import java.util.Arrays;

/**
 * 选择排序
 * 
 * @author pangguowei
 * @since 2020年11月20日 下午4:29:04
 */
public class SelectionSort {

	public static void main(String[] args) {
		// 4, 5, 6, 3, 2, 1
		// 1, 2, 3, 4, 5, 6
		int[] arr = { 4, 5, 6, 3, 2, 1 };
		selectionSort(arr);
	}
	
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return ;
		}
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			// 假设最小元素是第一个
			int minIdx = i;
			
			// 遍历查找最小元素
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			
			// 与当期位置交换数据
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
