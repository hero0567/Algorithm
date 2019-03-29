package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class ModalNumber {

    static int[] nums = new int[60];

    @BeforeClass
    public static void beforeClass() {
        int round = 30;
        Random random = new Random();
        for (int i = 0; i < round; i++) {
            nums[i] = random.nextInt(10);
        }
        int modalNumber = random.nextInt(10);
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

        for (int i = 0; i < count.length; i++) {
            if (count[i] > nums.length / 2) {
                System.out.println("result is:" + i);
            }
        }
    }

    @Test
    public void findModalNumberByHashMap() {
        //max number is 10
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            if (count == null){
                countMap.put(nums[i], 1);
            }else{
                countMap.put(nums[i], ++count);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                System.out.println("result is:" + entry.getKey());
            }
        }

    }
}
