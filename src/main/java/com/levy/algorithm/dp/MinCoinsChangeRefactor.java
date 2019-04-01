package com.levy.algorithm.dp;

public class MinCoinsChangeRefactor {

    public static int makeChange(int[] values, int coinKinds, int money,
                                 int[] coinsUsed) {
        coinsUsed[0] = 0;
        int minCoins = money + 1;
        for (int kind = 0; kind < coinKinds; kind++) {
            if (values[kind] <= money) {
                int preIndex = money - values[kind];
                //之前的index为0，则直接返回为1
                if (preIndex == 0) {
                    System.out.println("面值为 " + (money) + " 的最小硬币数 : 1");
                    return 1;
                }
                int prevValue = coinsUsed[preIndex];
                //-1 已经分解的结果为不能分解
                if (prevValue == -1) {
                    continue;
                }
                //0 表示还没计算
                if (prevValue == 0) {
                    prevValue = makeChange(values, coinKinds, preIndex, coinsUsed);
                    coinsUsed[preIndex] = prevValue;
                }
                //之前没有分解，现在分解的结果为-1，不能分解
                if (prevValue == -1) {
                    System.out.println("面值为 " + (money) + " 的最小硬币数 : -1");
                    continue;
                }

                int temp = coinsUsed[preIndex] + 1;
                if (temp < minCoins) {
                    minCoins = temp;
                }
            }
        }
        if (minCoins > money) {
            minCoins = -1;
        }
        coinsUsed[money] = minCoins;
        System.out.println("面值为 " + (money) + " 的最小硬币数 : "
                + coinsUsed[money]);


        return minCoins;
    }

    public static void main(String[] args) {

        int[] coinValue = new int[]{25, 21};
        int money = 121;
        int[] coinsUsed = new int[money + 1];
        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }
}
