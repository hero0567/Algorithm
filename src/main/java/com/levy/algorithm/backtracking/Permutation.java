package com.levy.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    @Test
    public void testPermutation() {
        String[] array = {"A", "B", "C"};
        List<String> result = new ArrayList<>();
        permutation(array, 0, result);
        for (String r : result) {
            System.out.println(r);
        }
    }

    @Test
    public void testPermutationWithDuplicate() {
        String[] array = {"A", "B", "C"};
        List<String> result = new ArrayList<>();
        permutationWithDuplicate(array, 0, result);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public void permutation(String[] array, int parent, List<String> result) {

        if (array.length - parent == 1) {
            return;
        }

        for (int i = parent; i < array.length; i++) {
            String tmp = array[i];
            array[i] = array[parent];
            array[parent] = tmp;
            result.add(Arrays.toString(array));
            permutation(array, parent + 1, result);

            array[parent] = array[i];
            array[i] = tmp;
        }
    }

    public void permutationWithDuplicate(String[] array, int parent, List<String> result) {

        if (array.length - parent == 1) {
            return;
        }

        for (int i = parent; i < array.length; i++) {
            String tmp = array[i];
            array[i] = array[parent];
            array[parent] = tmp;
            result.add(Arrays.toString(array));
            permutation(array, parent + 1, result);

            array[parent] = array[i];
            array[i] = tmp;
        }
    }

    public static void p(char[] array, int index) {
        char temp;
        if (index == array.length) {
            System.out.println(array);
            return;
        }
        if (array.length == 0 || index < 0 || index > array.length) {
            return;
        }
        for (int j = index; j < array.length; j++) {
            temp = array[j];
            array[j] = array[index];
            array[index] = temp;
            p(array, index + 1);
            temp = array[j];
            array[j] = array[index];
            array[index] = temp;
        }

    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};

        p(chars, 0);

    }
}
