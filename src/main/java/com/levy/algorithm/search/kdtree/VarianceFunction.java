package com.levy.search.kdtree;

import org.junit.Test;

public class VarianceFunction {

    public static void main(String[] args) {
        int[] array = {15, 96, 85, 88, 18, 58, 68, 16, 6, 99, 88, 11, 8, 36, 82, 44, 55, 66};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];      //求出数组的总和
        }
        System.out.println(sum);  //939
        double average = sum / array.length;  //求出数组的平均数
        System.out.println(average);   //52.0
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += (array[i] - average) * (array[i] - average);   //求出方差，如果要计算方差的话这一步就可以了
        }
        double standardDeviation = Math.sqrt(total / array.length);   //求出标准差
        System.out.println(standardDeviation);    //32.55764119219941
    }

    @Test
    public void sample1() {
        //5.8
        int[] array = {2, 5, 4, 8, 7, 9};
        calc(array);
    }

    @Test
    public void sample2() {
        //3.8
        int[] array = {3, 4, 7, 1, 2, 2};
        calc(array);
    }

    @Test
    public void sample3() {
        int[] array = {15, 96, 85, 88, 18, 58, 68, 16, 6, 99, 88, 11, 8, 36, 82, 44, 55, 66};
        calc(array);
    }


    public void calc(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];      //求出数组的总和
        }
        double average = sum / array.length;  //求出数组的平均数
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += (array[i] - average) * (array[i] - average);   //求出方差，如果要计算方差的话这一步就可以了
        }
        System.out.println("方差:" + total / array.length);
        double standardDeviation = Math.sqrt(total / (array.length - 1));   //求出标准差
        System.out.println("标准差:" + standardDeviation);    //32.55764119219941
    }


}
