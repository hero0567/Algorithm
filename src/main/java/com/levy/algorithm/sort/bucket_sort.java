package com.levy.sort;

public class bucket_sort {

	/**
	 * 鎶婅寖鍥寸缉灏忓埌0~9鏉ヤ妇涓牀瀛愶細
	 * 
	 * 3 9 1 2 2 7 5 3 0 1 3 4 鈥斺�� 鍘熸暟鎹�
	 * 
	 * [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] 鈥斺�� 10涓《
	 * 
	 * 0# 1# 2# 3# 4# 5# 6# 7# 8# 9# 鈥斺�� 妗剁紪鍙�
	 * 
	 * 閬嶅巻锛屼负姣忎釜妗惰鏁帮細
	 * 
	 * [1] [2] [2] [3] [1] [1] [0] [1] [0] [1]
	 * 
	 * 0# 1# 2# 3# 4# 5# 6# 7# 8# 9# 鈥斺�� 妗剁紪鍙�
	 * 
	 * 鍙互鐪嬪埌锛�0鍙锋《涓湁1涓暟锛�1鍙锋《涓湁2涓暟锛�2鍙锋《涓湁2涓暟銆傘�傘��8鍙锋《涓虹┖锛�9鍙锋《鏈�1涓暟銆備簬鏄皢鎵�鏈夋暟鎹緭鍑猴紝0杈撳嚭1娆★紝1杈撳嚭2娆★紝2
	 * 杈撳嚭2娆°�傘�傘��8涓嶈緭鍑猴紝9杈撳嚭1娆★細
	 * 
	 * 0 1 1 2 2 3 3 3 4 5 7 9
	 */
	public static void main(String[] args) {
		int[] unsorted = { 1, 54, 6, 35, 62, 54,78, 12, 35, 48, 3, 5, 6, 87, 45, 16, 54 };
		int[] sorted = bucket_sort(unsorted, 100);
		for (int i = 0; i < sorted.length; i++) {
			//if (sorted[i] > 0)System.out.print(i + " "); //去掉重复的
			for (int count = 0; count < sorted[i]; count++) {
				System.out.print(i + " ");
			}
		}
	}

	/**
	 * 鍖洪棿涓嶅ぇ锛岃嚦灏戠浉瀵规暟缁勭殑鏁伴噺涓嶆槸涓�涓骇鍒�
	 * 
	 * @param unsorted
	 * @param maxNumber
	 * @return
	 */
	static int[] bucket_sort(int[] unsorted, int maxNumber) {
		int[] sorted = new int[maxNumber];
		for (int i = 0; i < unsorted.length; i++) {
			sorted[unsorted[i]]++; //重复的累加
		}
		return sorted;
	}

}
