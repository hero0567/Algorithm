package com.levy.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringSplitGroup {

    @Test
    public void testStringSplitGroup() {
        String s = "hello";
        List<String> result = new ArrayList<>();
        splitStringToGroup(s, "", result);


        for (String r : result) {
            System.out.println(r);
        }

    }

    @Test
    public void test() {
        String s = "hello";
        System.out.println(s.substring(1, s.length()));
    }

    public void splitStringToGroup(String s, String parent, List<String> result) {
        if (s.length() == 1) {
            result.add(parent + s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String head = parent + "(" + s.substring(0, 0 + 1) + ")";
            String tail = "(" + s.substring(0 + 1, s.length()) + ")";
            result.add(head + tail);
            splitStringToGroup(tail, parent, result);

        }
    }
}
