package com.levy.search;

public class yanghui {

	public static void main(String[] args) {
		int n = 10;
		int[][] ary = new int[n][n];
		int[] resut = fn(n, ary);
		ary[n -1] = resut;
		
		System.out.println(ary);
	}
	
	public static int[] fn(int n, int[][] ary){
		
		if (n == 1){
			return new int[]{1};
		}
	
		int[] a = fn(n-1, ary);
		int[] resut = new int[n];
		
		for(int i=0; i < a.length; i++){
			if (i == 0){
				resut[i] = a[i];
				resut[a.length] = a[i];
				continue;
			}
			resut[i] = a[i-1] + a[i];
		}
		
		ary[n-2] = a;
		return resut;
	}

}
