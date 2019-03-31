package com.levy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("112");
        words.add("12");

        String shortestWord = words.stream().min(
                Comparator.comparing(
                        word -> word.length()))
                .get();
        System.out.println(shortestWord);
    }
}
