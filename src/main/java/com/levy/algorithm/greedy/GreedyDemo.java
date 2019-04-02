package com.levy.algorithm.greedy;


import org.junit.Test;

/**
 * 贪心算法不能在所有情况下得出最优解，但是能得出近最优解
 */
public class GreedyDemo {
    public static void main(String[] args) {

    }

    @Test
    public void testGreedy(){
        //人民币面值集合
        int[] values = { 1, 2, 5, 10, 20, 50, 100 };
        //各种面值对应数量集合
        int[] counts = new int[values.length];
        //求442元人民币需各种面值多少张
        int[] num = change(442, values, counts);
        print(num, values);
    }

    /**
     * 最优解应该是 2个55，方法的出来的不是最优解
     */
    @Test
    public void testGreedyNotBestSolution(){
        //人民币面值集合
        int[] values = { 1, 2, 5, 11, 20, 55, 100 };
        //各种面值对应数量集合
        int[] counts = new int[values.length];
        //求442元人民币需各种面值多少张
        int[] num = change(110, values, counts);
        print(num, values);
    }

    public static int[] change(int money, int[] values, int[] counts) {
        //用来记录需要的各种面值张数
        int[] result = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            int num = 0;
            //需要最大面值人民币张数
            int c = money / values[i];
            //剩下钱数
            money = money % values[i];
            //将需要最大面值人民币张数存入数组
            num += c;
            result[i] = num;
        }
        return result;
    }

    /**
     * 返回最小值
     */
    private static int min(int i, int j) {
        return i > j ? j : i;
    }

    private static void print(int[] num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num[i] != 0) {
                System.out.println("需要面额为" + values[i] + "的人民币" + num[i] + "张");
            }
        }
    }
}