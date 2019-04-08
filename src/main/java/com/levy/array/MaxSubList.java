package com.levy.array;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubList {


    @Test
    public void testMaxProduct() {
        int[] nums = {-1, 2, 3};
        Assert.assertEquals(6, maxProduct(nums));

        int[] nums1 = {2, 3, -2, 4};
        Assert.assertEquals(6, maxProduct(nums1));

        int[] nums2 = {-2, 0, -1};
        Assert.assertEquals(0, maxProduct(nums2));
    }


    /**
     * 因为是相乘，如果不考虑负数，肯定越多个数字积越大
     * 现在就是考虑排除负数的影响
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            //前面的数组偏小，就需要丢弃，但是在此遇见负数还需要交换
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            //前半截和后半截的比较
            max = Math.max(max, imax);
        }
        return max;
    }
}
