package com.gerry.sort.nlogn;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author pangguowei
 */
public class MergeSort {
	public static void main(String[] args) {
		// 4, 5, 6, 3, 2, 1
		int[] arr = { 4, 5, 6, 3, 2, 1 ,0, 11};
		mergeSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int n) {
		mergeSortInternally(arr, 0, n - 1);
	}

	private static void mergeSortInternally(int[] arr, int i, int j) {
		if (i >= j) {
			return;
		}

		int medle = i + (j - i) / 2;
		mergeSortInternally(arr, i, medle);
		mergeSortInternally(arr, medle + 1, j);

//		mergerBySentry(arr, i, medle, j);
		merger(arr, i, medle, j);
	}

	private static void merger(int[] arr, int p, int q, int r) {
		System.out.println("p,q,r:" + p + "," + q + "," + r + "===" + Arrays.toString(arr));
		int i = p;
		int j = q + 1;
		int k = 0; // 初始化变量i, j, k
		int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
		
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++]; // i++等于i:=i+1
			} else {
				tmp[k++] = arr[j++];
			}
		}

		// 判断哪个子数组中有剩余的数据
		int start = i;
		int end = q;
		if (j <= r) {
			start = j;
			end = r;
		}

		// 将剩余的数据拷贝到临时数组tmp
		while (start <= end) {
			tmp[k++] = arr[start++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (i = 0; i <= r - p; ++i) {
			arr[p + i] = tmp[i];
		}
		System.out.println("++=="+Arrays.toString(tmp));
	}

	private static void mergerBySentry(int[] arr, int i, int medle, int j) {

	}
}
