package com.levy.algorithm.dp;

import java.util.Random;

/**
 * 数塔问题是动态规划经典的题目，下面来初步讲解下
 * <p>
 * 将一个由N行数字组成的三角形，如图所以，设计一个算法，计算出三角形的由顶至底的一条路径，使该路径经过的数字总和最大。
 */
public class NumberTower {

    /**
     * f[i][j] = max(f[i+1][j], f[i+1][j+1]) + map[i][j]
     * <p>
     * 当前节点的最大值为：正下方的2个节点(j,j+1)的max加上节点本身的值
     */


    public static void main(String[] args) {
        int[][] map = new int[9][9];

        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i + 1; j++) {
                int r = random.nextInt(30);
                map[i][j] = r;
                System.out.print(r + "-");
            }
            System.out.println();
        }
        int max = getShortestPath(map);
        System.out.println("Max:" + max);
    }

    public static int getShortestPath(int[][] map) {
        int n = map.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                //覆盖2个字节点的父节点的值
                map[i - 1][j] = map[i - 1][j] + Math.max(map[i][j], map[i][j + 1]);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(map[i][j] + "-");
            }
            System.out.println();
        }
        return map[0][0];
    }
}


