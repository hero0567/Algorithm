package com.levy.algorithm.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class SplitWordDictWithGroup {

    @Test
    public void testSplitWordDict() {
        String s = "aaaa";
        String[] wordDict = {"a", "aa"};
        List<List<String>> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        splitWordDict(s, wordDict, result, tempResult);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }

    }

    @Test
    public void testSplitWordDict1() {
        String s = "helloworld";
        String[] wordDict = {"hello", "world"};
        List<List<String>> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        splitWordDict(s, wordDict, result, tempResult);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }
    }

    @Test
    public void testSplitWordDict2() {
        String s = "abc";
        String[] wordDict = {"abc", "bcd"};
        List<List<String>> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        splitWordDict(s, wordDict, result, tempResult);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }
    }

    @Test
    public void testSplitWordDict3() {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        List<List<String>> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        splitWordDict(s, wordDict, result, tempResult);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }
    }

    @Test
    public void testSplitWordDict4() {
        String s = "catsanddog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        List<List<String>> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        splitWordDict(s, wordDict, result, tempResult);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }
    }

    public void splitWordDict(String s, String[] wordDict, List<List<String>> result, List<String> tempResult) {
        if (s.length() == 0) {
            List<String> mathedResult = new ArrayList<>(tempResult);
            result.add(mathedResult);
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                tempResult.add(word);
                splitWordDict(s.substring(word.length()), wordDict, result, tempResult);
                tempResult.remove(word);
            }
        }
    }
}
