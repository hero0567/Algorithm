package com.levy.algorithm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeOrderedArray {

    static int m = 2;
    static int n = 3;
    static int[] nums1 = new int[m + n];
    static int[] nums2 = new int[n];

    @BeforeClass
    public static void beforeClass() {
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                nums1[i] = random.nextInt(10);
            } else {
                nums1[i] = nums1[i - 1] + random.nextInt(10);
            }
            System.out.println("nums1:" + nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums2[i] = random.nextInt(10);
            } else {
                nums2[i] = nums2[i - 1] + random.nextInt(10);
            }
            System.out.println("nums2:" + nums2[i]);
        }
    }

    @Test
    public void mergeArray() {
        for (int i = m - 1, j = n - 1, k = m + n - 1; i > -1 || j > -1 || k > -1; ) {
            boolean c = false;
            if (i > -1 && j > -1) {
                c = nums1[i] >= nums2[j];
            }

            if (j == -1 || c) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        for (int i = 0; i < m + n; i++) {
            System.out.println("Merged:" + nums1[i]);
            if (i + 1 < m + n && nums1[i] > nums1[i + 1]) {
                Assert.fail();
            }
        }
    }
}
