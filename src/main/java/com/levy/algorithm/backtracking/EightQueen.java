package com.levy.algorithm.backtracking;

import org.junit.Test;

/**
 * 将八个皇后摆在一张8*8的国际象棋棋盘上，使每个皇后都无法吃掉别的皇后，一共有多少种摆法
 */
public class EightQueen {

    private int n = 8;
    private int total = 0;

    @Test
    public void testEightQueen() {
        //n是皇后数 row为现在正执行到第几行
        int row = 0;
        int[] c = new int[n];
        queen(c, row);
        System.out.println(total);

    }

    public void queen(int[] c, int row) {
        //row=0 开始 只需要在row=0的时候在所有的col找出所有的解
        if (row == n)
            total++;
        else
            for (int col = 0; col != n; col++) {
                //c[0]=0 到c[0]=7 的所有解
                c[row] = col;
                if (isOk(c, row))
                    queen(c, row + 1);
            }
    }

    private boolean isOk(int[] c, int row) {
        for (int j = 0; j != row; j++) {
            //c[row] == c[j] 同一列
            //
            if (c[row] == c[j] || row - c[row] == j - c[j] || row + c[row] == j + c[j])
                return false;
        }
        return true;
    }
}
