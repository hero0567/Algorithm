package com.levy.sort;

public class BubbleMaoPao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] unsorted = { 1, 54, 6, 35, 62, 78, 12, 35, 48, 3, 5, 6, 87, 45, 16, 54 };
		bubble_sort(unsorted);
		for (int i: unsorted){
			System.out.print(i +" ");
		}
	}
	
	
	public static void bubble_sort(int[] unsorted)
    {
        for (int i = 0; i < unsorted.length; i++)
        {
            for (int j = i+1; j < unsorted.length; j++)
            {
                if (unsorted[i] > unsorted[j])
                {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }
   
}
