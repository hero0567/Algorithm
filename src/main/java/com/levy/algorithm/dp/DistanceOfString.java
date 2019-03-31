package com.levy.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;


public class DistanceOfString {

    public static int getResult(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        //dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= B.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[A.length()][B.length()];
    }


    @Test
    public void testDistance1() {
        String A = "ALGORITHM";
        String B = "ALTRUISTIC";
        int d = getResult(A, B);
        Assert.assertEquals(6, d);
    }

    @Test
    public void testDistance2() {
        String A = "abcd";
        String B = "acd";
        int d = getResult(A, B);
        Assert.assertEquals(1, d);
    }

    @Test
    public void testDistance3() {
        String A = "ac";
        String B = "ab";
        int d = getResult(A, B);
        Assert.assertEquals(1, d);
    }

    @Test
    public void testDistance4() {
        String A = "abcdefgfi";
        String B = "abdekgfly";
        int d = getResult(A, B);
        Assert.assertEquals(4, d);
    }
}