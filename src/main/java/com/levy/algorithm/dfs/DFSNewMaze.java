package com.levy.algorithm.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 返回结果，而不是print出来
 */
public class DFSNewMaze {
    /**
     * DFS算法解决走迷宫问题
     * 0: 表示通路
     * 1: 表示死路
     */
    static List<List<int[]>> allPaths = new ArrayList<>();


    @Test
    public void findALLPath(){
        // 初始化一个迷宫地图 // 0: 表示通路 // 1:表示死路
        int[][] maze = {{0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}};
        /*
         * 从矩阵的左上角位置开始搜索
         * */
        List<int[]> result = new ArrayList<>();
        dfsMaze(0, 0, maze, result);

        allPaths.forEach(path -> {
            System.out.print("找到线路步数为:" + path.size() + ":");
            path.forEach(p ->{
                System.out.print("(" + p[0] + "," + p[1] + ")-");
            });
            System.out.println();
        });
    }

    @Test
    public void findShortestPath(){
        // 初始化一个迷宫地图 // 0: 表示通路 // 1:表示死路
        int[][] maze = {{0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}};
        /*
         * 从矩阵的左上角位置开始搜索
         * */
        List<int[]> result = new ArrayList<>();
        dfsMaze(0, 0, maze, result);

        allPaths.forEach(path -> {
            System.out.print("找到线路步数为:" + path.size() + ":");
            path.forEach(p ->{
                System.out.print("(" + p[0] + "," + p[1] + ")-");
            });
            System.out.println();
        });

        List<int[]>  shortPath = allPaths.stream().
                min(Comparator.comparing(path -> path.size())).get();

        System.out.print("找到最短路线步数为:" + shortPath.size() + ":");
        shortPath.forEach(p ->{
            System.out.print("(" + p[0] + "," + p[1] + ")-");
        });
    }


    public static void dfsMaze(int x, int y, int[][] maze, List<int[]> result) {
        /*
         * 获得矩阵的大小
         * */
        int m = maze.length;
        int n = maze[0].length; //设置结束条件
        if (x < 0 || y < 0) return; // 如果坐标越界，或者 maze[x][y]==1 表示遇到障碍
        if (x > m - 1 || y > n - 1 || maze[x][y] == 1) return; //判断是否通路和越界
        if (x == m - 1 && y == n - 1) {
            List<int[]> dest = new ArrayList<>();
            dest.addAll(result);
            dest.add(new int[]{x, y});
            allPaths.add(dest);
            return;
        }
        int tempLen = result.size();
        result.add(new int[]{x, y});

        //同一次，相同的点不能重复的走
        maze[x][y] = 1; // 将走过的路标记
        // 向四个方向搜索
        dfsMaze(x + 1, y, maze, result); //向右搜索
        dfsMaze(x, y + 1, maze, result); //向下搜索
        dfsMaze(x, y - 1, maze, result); //向上搜索
        dfsMaze(x - 1, y, maze, result); //向左搜索

        //不同的线路，可以走重复的点
        // 将路线和标记恢复成上一次的状态
        maze[x][y] = 0;
        //清除
        //如果已经找出出口，则在最后一次迭代中output了，则清楚尝试找下一个方案
        //如果是死路，也需要把后面的路清除，则清楚尝试找下一个方案
        for (int i = tempLen; i < result.size(); i++) {
            result.remove(i);
        }
    }
}
