package com.levy.sort;

public class InsertionSorter   
{   
	public static void main(String[] args) {
		int[] unsorted = { 99, 1, 54, 6, 35, 62, 78, 12, 35, 48, 3, 5, 6, 87, 45, 16, 54 };
		insertion_sort(unsorted);
		for (int i: unsorted){
			System.out.print(i +" ");
		}
	}
	
    public static void insertion_sort(int[] unsorted)
    {
        for (int i = 1; i < unsorted.length; i++)
        {
            if (unsorted[i - 1] > unsorted[i])
            {
            	//temp为需要插入的数
                int temp = unsorted[i];
                int j = i;
                //unsorted[j-1]为已经排序好的数，比较unsorted[j]==temp当前数的
                while (j > 0 && unsorted[j - 1] > temp)
                {
                	//如果，已经排序好的数，比temp大的数向右移动一位，
                	//之前已经排好序的数的长度为j-1,多了一个插入数，则长度加一，变为j
                    unsorted[j] = unsorted[j - 1];
                    //比较下一个已经排序好的数
                    j--;
                }
                //把temp需要插入的数，插入到合适的位置
                unsorted[j] = temp;
            }
        }
    }
}    
