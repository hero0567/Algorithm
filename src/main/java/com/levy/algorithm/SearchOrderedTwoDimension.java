package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */

public class SearchOrderedTwoDimension {

    private static final int ROW = 4;
    private static final int COLUMN = 4;
    private static int[][] matrix = new int[ROW][COLUMN];

    @BeforeClass
    public static void beforeClass() {

        Random random = new Random();

        for (int j = 0; j < ROW; j++) {
            for (int k = 0; k < COLUMN; k++) {
                int d = random.nextInt(10);
                int v = -1;
                if (j == 0 && k == 0) {
                    v = d;
                } else if (j == 0) {
                    //the behind should be bigger than before
                    v = matrix[j][k - 1] + d;

                } else if (k == 0) {
                    v = matrix[j - 1][k] + d;
                } else {
                    //the next and bihand should be bigger than before and above
                    v = matrix[j][k - 1] + matrix[j - 1][k] + d;
                }
                System.out.println(j + ":" + k + ":" + v);
                matrix[j][k] = v;
            }
        }
        System.out.println("Init end");
    }

    @Test
    public void testSearchOrderMatrix() {
        Random random = new Random();
        int expected = random.nextInt(100);
        while (!searchOrderMatrix(expected)) {
            expected = random.nextInt(100);
        }
    }

    private boolean searchOrderMatrix(int expected) {
        boolean found = false;
        for (int j = 0; j < COLUMN; j++) {
            for (int k = 0; k < ROW; k++) {
                if (expected >= matrix[j][k]) {
                    if (expected == matrix[j][k]) {
                        found = true;
                    }
                    if (j > 0 && expected == matrix[j - 1][k]) {
                        found = true;
                    }
                    if (k > 0 && expected == matrix[j][k - 1]) {
                        found = true;
                    }
                    if (found) {
                        System.out.println("Found -> " + j + ":" + k + ":" + expected);
                    }
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Found:" + expected);
        } else {
            System.out.println("Not found:" + expected);
        }
        return found;
    }
}
