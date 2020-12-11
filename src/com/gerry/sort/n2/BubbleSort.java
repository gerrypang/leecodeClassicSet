package com.gerry.sort.n2;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author pangguowei
 * @since 2020年11月17日
 */
public class BubbleSort {

	public static void main(String[] args) {
		// 4, 5, 6, 3, 2, 1
		int[] arr = { 1, 2, 3, 4, 5, 6 };
//		bubbleSort1(arr);
		bubbleSort2(arr);
	}
	
	public static void bubbleSort1(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return ;
		}
		
		int n = arr.length;
		// 从小到大
		for (int i = 0; i < n; i++) {
			/**
			 * 优化：提前退出标志位
			 * 标记一次循环后是否有数据交换操作，没有则当前序列为有序，不用在遍历
			 */ 
			boolean flag = false; // 优化点
			for (int j = 0; j < n - i - 1; j++) { // 重点
				if (arr[j] > arr[j + 1]) { // 重点
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = true;
				}
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(flag);
			System.out.println("================================");
			if(!flag) break;  // 优化点
		}
		
		System.out.println(Arrays.toString(arr));
	}
	

	public static void bubbleSort2(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return ;
		}
		
		int lastIndex = 0;
		int n = arr.length; 
		// 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
		// 从小到大
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < sortBorder; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = true;
					// 更新最后一次交换的位置
					lastIndex = j;
				}
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(lastIndex);
			System.out.println("================================");
			sortBorder = lastIndex;
			if(!flag || lastIndex == 0) break;
		}
		
		//System.out.println(Arrays.toString(arr));
	}
	
}
