package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * <p>
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class EggDrop {


    static int f = 8, n = 2, k = 10;

    @BeforeClass
    public static void beforeClass() {

    }

    @Test
    public void testEggDropFloor() {
        int step = getStep(n, 0);
        System.out.println("Min step is:" + step);
    }

    public int getStep(int n, int step) {
        if (n <= 1) {
            return n;
        }
        n = n / 2 + n % 2;
        step = getStep(n, step) + 1;
        return step;
    }

    @Test
    public void test() {
        int n =2;
        System.out.println(n / 2 + n % 2);
    }
}
