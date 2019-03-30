package com.levy.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class SearchOrderedTwoDimension {

    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static int[][] matrix = new int[ROW][COLUMN];

    @BeforeClass
    public static void beforeClass() {

        Random random = new Random();

        for (int j = 0; j < ROW; j++) {
            for (int k = 0; k < COLUMN; k++) {
                int d = random.nextInt(10);
                int v = -1;
                if (j == 0 && k == 0) {
                    v = d;
                } else if (j == 0) {
                    //the behind should be bigger than before
                    v = matrix[j][k - 1] + d;

                } else if (k == 0) {
                    v = matrix[j - 1][k] + d;
                } else {
                    //the next and bihand should be bigger than before and above
                    v = matrix[j][k - 1] + matrix[j - 1][k] + d;
                }
                System.out.println(j + ":" + k + ":" + v);
                matrix[j][k] = v;
            }
        }
        System.out.println("Init end");
    }

    @Test
    public void testSearchOrderMatrix() {
        Random random = new Random();
        int expected = random.nextInt(100);
        while (!searchOrderMatrix(expected)) {
            expected = random.nextInt(100);
        }
    }

    private boolean searchOrderMatrix(int expected) {
        boolean found = false;
        for (int j = 0; j < COLUMN; j++) {
            for (int k = 0; k < ROW; k++) {
                if (expected >= matrix[j][k]) {
                    if (expected == matrix[j][k]) {
                        found = true;
                    }
                    if (j > 0 && expected == matrix[j - 1][k]) {
                        found = true;
                    }
                    if (k > 0 && expected == matrix[j][k - 1]) {
                        found = true;
                    }
                    if (found) {
                        System.out.println("Found -> " + j + ":" + k + ":" + expected);
                    }
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Found:" + expected);
        } else {
            System.out.println("Not found:" + expected);
        }
        return found;
    }
}
