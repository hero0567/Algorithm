package com.levy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        int len = 10;
        int[] a = new int[len];
        int[] b = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                a[i] = random.nextInt(10) + 1;
                b[i] = random.nextInt(10) + 1;
                continue;
            }
            a[i] = a[i - 1] + random.nextInt(10) + 1;
            b[i] = b[i - 1] + random.nextInt(10) + 1;
        }

        print(a, b, len);
    }

    public static void print(int[] a, int[] b, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + "->");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(b[i] + "->");
        }
    }

}
