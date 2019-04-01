package com.levy.sort;

public class radix_sort {

	
	public static void main(String[] args) {
		int[] unsorted = { 8, 54, 6, 135, 62, 78, 12, 35, 148, 3, 5, 6, 87, 45, 16, 54 };
		radix_sort(unsorted, 10, 100);
		for (int i: unsorted){
			System.out.print(i +" ");
		}
	}
	
	// <summary>
	// 基数排序
	// 约定:待排数字中没有0,如果某桶内数字为0则表示该桶未被使用,输出时跳过即可
	// </summary>
	// <param name="unsorted">待排数组</param>
	// <param name="array_x">桶数组第一维长度</param>
	// <param name="array_y">桶数组第二维长度</param>
	static void radix_sort(int[] unsorted, int array_x, int array_y) {
		for (int i = 0; i < array_x/* 最大数字不超过999999999...(array_x个9) */; i++) {
			int[][] bucket = new int[array_x][array_y];
			for (int item : unsorted) {
				int temp = (item / (int) Math.pow(10, i)) % 10;
				for (int l = 0; l < array_y; l++) {
					if (bucket[temp][l] == 0) {
						bucket[temp][l] = item;
						break;
					}
				}
			}
			for (int o = 0, x = 0; x < array_x; x++) {
				for (int y = 0; y < array_y; y++) {
					if (bucket[x][y] == 0)
						continue;
					unsorted[o++] = bucket[x][y];
				}
			}
		}
	}

}
