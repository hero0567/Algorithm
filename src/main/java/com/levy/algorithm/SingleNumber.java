package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    private static List<Integer> list = new ArrayList<>();

    @BeforeClass
    public static void beforeClass() {
        Random random = new Random();
        list.add(random.nextInt(100));
        IntStream.generate(() -> random.nextInt(100)).limit(50).forEach(n -> {
            list.add(n);
            list.add(n);
        });
    }

    @Test
    public void testSingleNumber() {
        System.out.println("Odd number: " + list.get(0));

        Optional<Integer> result = list.stream().reduce((sum, n) -> sum ^ n);

        System.out.println("result :" + result.get());
    }

    @Test
    public void singleNumber() {

        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
                set.remove(nums[i]); // 删除重复出现的数字
            }
        }
        System.out.println("result :" + set.iterator().next());
    }

}
