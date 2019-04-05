package com.levy.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 把字符串分解我不同的组
 */
public class StringSplitGroup {

    @Test
    public void test01() {
        String s = "h";
        List<String> result = new ArrayList<>();
        splitStringToGroup(s, "", result);
        for (String r : result) {
            System.out.println(r);
        }

    }

    @Test
    public void test02() {
        String s = "h2";
        List<String> result = new ArrayList<>();
        splitStringToGroup(s, "", result);
        for (String r : result) {
            System.out.println(r);
        }

    }

    @Test
    public void test03() {
        String s = "h12";
        List<String> result = new ArrayList<>();
        splitStringToGroup(s, "", result);
        for (String r : result) {
            System.out.println(r);
        }

    }

    @Test
    public void test04() {
        String s = "hello";
        List<String> result = new ArrayList<>();
        splitStringToGroup(s, "", result);
        for (String r : result) {
            System.out.println(r);
        }

    }

    public void splitStringToGroup(String s, String parent, List<String> result) {

        if(parent.length() == 0){
            result.add("(" + s + ")");
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String head = parent + "(" + s.substring(0, i + 1) + ")";
            String tail = s.substring(i + 1, s.length());
            result.add(head + "(" + tail + ")");
            splitStringToGroup(tail, head, result);
        }


    }
}
