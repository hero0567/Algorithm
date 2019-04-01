package com.levy.sort;

public class Quick_sort {

	
	public static void main(String[] args) {
		int[] unsorted = { 8, 54, 6, 35, 62, 78, 12, 35, 48, 3, 5, 6, 87, 45, 16, 54 };
		quick_sort(unsorted, 0, unsorted.length - 1);
		for (int i: unsorted){
			System.out.print(i +" ");
		}
	}
	
	 static int partition(int[] unsorted, int low, int high)
     {
         int pivot = unsorted[low];
         while (low < high)
         {
             while (low < high && unsorted[high] > pivot) 
            	 high--;
             unsorted[low] = unsorted[high];
             while (low < high && unsorted[low] <= pivot) 
            	 low++;
             unsorted[high] = unsorted[low];
         }
         unsorted[low] = pivot;
         return low;
     }

     static void quick_sort(int[] unsorted, int low, int high)
     {
         int loc = 0;
         if (low < high)
         {
             loc = partition(unsorted, low, high);
             quick_sort(unsorted, low, loc - 1);
             quick_sort(unsorted, loc + 1, high);
         }
     }
}
