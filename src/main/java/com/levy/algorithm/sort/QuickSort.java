package com.levy.sort;

import edu.emory.mathcs.backport.java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] a = {2, 23, 5, 67, 12, 23, 45, 45, 1, 2, 99,3 ,5};
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static void quickSort(int[] a, int low, int high) {
		if (low < high){
			int part = getPartition(a, low, high);
			quickSort(a, low, part -1);
			quickSort(a, part+1, high);
		}
	}

	private static int getPartition(int[] a, int low, int high) {
		
		int pivot = a[low];
		while(low < high){
			while(low < high && a[high] > pivot){
				high--;
			}
			a[low] = a[high]; 
			while(low < high && a[low] <= pivot){
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
}
