package com.levy.algorithm.backtracking;


/**
 * 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格。一个机器人从坐标(0,0)的给子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.请问该机器人能够到达多少个格子。
 */
public class MatrixTable {
    public static void main(String[] args) {
        int rows = 10, cols = 10;
        int row = 0, col = 0;
        int maxK = 18;
        boolean[][] isVisited = new boolean[rows][cols];
        int count = moveCountCore(maxK, rows, cols, row, col, isVisited);
        System.out.println("Could move:" + count);
    }

    static int getMaxtrixSum(int n, int m) {
        int sum = 0;
        while (n > 0) {
            sum += sum % 10;
            sum /= 10;
        }
        while (m > 0) {
            sum += sum % 10;
            sum /= 10;
        }
        return sum;
    }

    //检查机器人是否可以进入该坐标（row,col）
    static boolean check(int maxK, int rows, int cols, int row, int col, boolean[][] isVisited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && getMaxtrixSum(row, col) > 0 && !isVisited[row][col])
            return true;
        return false;
    }

    static int moveCountCore(int maxK, int rows, int cols, int row, int col, boolean[][] isVisited) {
        int count = 0;
        if (check(maxK, rows, cols, row, col, isVisited)) {
            isVisited[row][col] = true;
            //这个count只是当前节点以及以后的总和，没有前面的，前面的要等递归回去之后加上 count = 1 + moveCountCore(maxK, rows, cols, row - 1, col, isVisited) + moveCountCore(maxK, rows, cols, row + 1, col, isVisited) + moveCountCore(maxK, rows, cols, row, col - 1, isVisited) + moveCountCore(maxK, rows, cols, row, col + 1, isVisited); } return count; } int moveCount(int maxK, int rows, int cols) { if (maxK < 0 || rows <= 0 || cols <= 0) return 0; bool *isVisited = new bool[rows*cols]; for (int i = 0; i < rows*cols; i++) isVisited[i] = false; int count = moveCountCore(maxK, rows, cols, 0, 0, isVisited);
            //还是要记得释放内存空间！！
            return count;
        }
        return count;

    }
}
