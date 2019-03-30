package com.levy.algorithm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class ModalNumber {

    static int[] nums = new int[60];
    static int modalNumber = 0;

    @BeforeClass
    public static void beforeClass() {
        int round = 30;
        Random random = new Random();
        for (int i = 0; i < round; i++) {
            nums[i] = random.nextInt(10);
        }
        modalNumber = random.nextInt(10);
        for (int i = 0; i < round; i++) {
            nums[i + 30] = modalNumber;
        }
        System.out.println("Modal number is: " + modalNumber);
    }

    @Test
    public void findModalNumberByArray() {
        //max number is 10
        int[] count = new int[10];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int result = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > nums.length / 2) {
                System.out.println("result is:" + i);
                result = i;
                break;
            }
        }

        Assert.assertEquals(modalNumber, result);
    }

    @Test
    public void findModalNumberByHashMap() {
        //max number is 10
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            if (count == null) {
                countMap.put(nums[i], 1);
            } else {
                countMap.put(nums[i], ++count);
            }
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                System.out.println("result is:" + entry.getKey());
                result = entry.getKey();
                break;
            }
        }
        Assert.assertEquals(modalNumber, result);

    }
}
