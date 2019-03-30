package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class MatrixTranspose {


    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static int[][] matrix = new int[ROW][COLUMN];

    @BeforeClass
    public static void beforeClass() {
        int i = 0;
        for (int j = 0; j < ROW; j++) {
            for (int k = 0; k < COLUMN; k++) {
                ++i;
                System.out.println(j + ":" + k + ":" + i);
                matrix[j][k] = i;
            }
        }
        System.out.println("Init end");
    }

    /**
     * 时间复杂度：O(R∗C)O(R * C)O(R∗C)，其中 RRR 和 CCC 是给定矩阵 A 的行数和列数。
     * <p>
     * 空间复杂度：O(R∗C)O(R * C)O(R∗C)，也就是答案所使用的空间。
     */
    @Test
    public void testMatrixTransposeSwitch() {
        //change column and row position
        int[][] result = new int[COLUMN][ROW];
        for (int j = 0; j < COLUMN; j++) {
            for (int k = 0; k < ROW; k++) {
                int v = matrix[k][j];
                System.out.println(j + ":" + k + ":" + v);
                result[j][k] = v;
            }
        }
    }
}
