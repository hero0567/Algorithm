package com.levy.search;

public class rabbit {
	public static final int MONTH = 15;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long f1 = 1L, f2 = 1L;
        long f;
//        for(int i=3;i<MONTH;i++){
//            f=f1+f2;
//            f1=f2;
//            f2=f;
//            System.out.println("第"+i+"个月的兔子对数："+f2);
//        }
        
        for(int i =1 ; i<3; i++){
            System.out.println("第"+i+"个月的兔子对数："+fib(i));
        }
        
    }
    //递归方法实现
    public static int fib(int month){
        if(month == 1 || month == 2){
            return 1;
        }else{
            return fib(month-1)+fib(month-2);
        }
    }
}
