package com.levy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

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
