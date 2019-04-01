package com.levy.search;

public class Test3Quit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		int[] a = new int[n];
		for(int i=0;i< n; i ++){
			a[i] = i +1;
		}
		
		int[] b = fn(a);
		System.out.println(b);
		main();
	}
	
	public static int[] fn(int[] a){
		if (a.length < 3){
			return a;
		}
		
		int len = a.length - a.length/3;
		int[] res = new int[len];
		for (int i=0, j=0; i < a.length; i++){
			if((i+1)%3 != 0){
				res[j] = a[i];
				j++;
			}
		}
		
		int[] b = fn(res);
		return b;
	}
	
	
	public static void main() {
        int n = 11;
        int[] a = new int[n];
        int i = 0;
        int t = 0;
        while (n > 1) {
            if (a[i] == 0) {
                t++;
                if (t == 3) {
                    t = 0;
                    a[i] = 1;
                    n--;
                }
            }
            i++;
            if(i == a.length){
                i = 0;
            }
        }
        for(int j=0;j<a.length;j++){
            if(a[j]!=1){
                System.out.println(j+1);
            }    
        }
    }
	
	

}
