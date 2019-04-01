package com.levy.algorithm.dp;

import org.junit.Test;

public class MinCoinsChange {
    /**
     * 硬币找零问题描述：现存在一堆面值为 V1、V2、V3 … 个单位的硬币，问最少需要多少个硬币才能找出总值为 T 个单位的零钱？
     * 假设这一堆面值分别为 1、2、5、21、25 元，需要找出总值 T 为 63 元的零钱。
     *
     * 硬币找零：动态规划算法
     *
     * @param values
     *            :保存每一种硬币的币值的数组
     * @param valueKinds
     *            :币值不同的硬币种类数量，即coinValue[]数组的大小
     * @param money
     *            :需要找零的面值
     * @param coinsUsed
     *            :保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {

            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }

    public static void main(String[] args) {

        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        // 需要找零的面值
        int money = 63;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];

        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }


    @Test
    public void antherSolution() {

        int a[] = {1, 3, 5}, sum = 11, cent = 0;
        int[] dp = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            dp[i] = i;//我们假设存在1元的硬币那么i元最多只需要i枚1元硬币，当然最好设置dp[i]等于无穷大
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= a[j] && dp[i - a[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - a[j]] + 1;
                }
            }
        }

        for (int i = 0; i <= sum; i++) {
            System.out.println(i + "的最优解释：" + dp[i]);

        }
    }
}
