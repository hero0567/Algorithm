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
        String s = "aaa";
        String[] wordDict = {"a", "aa"};
        List<List<String>> result = new ArrayList<>();

        splitWordDict(s, wordDict, result, 0);
        for (List<String> r : result) {
            System.out.println(String.join(":", r));
        }

    }
//
//    @Test
//    public void testSplitWordDict1() {
//        String s = "helloworld";
//        String[] wordDict = {"hello", "world"};
//        List<String> result = new ArrayList<>();
//
//        boolean match = splitWordDict(s, wordDict, result);
//        Assert.assertTrue(match);
//    }
//
//    @Test
//    public void testSplitWordDict2() {
//        String s = "abc";
//        String[] wordDict = {"abc", "bcd"};
//        List<String> result = new ArrayList<>();
//
//        boolean match = splitWordDict(s, wordDict, result);
//        Assert.assertTrue(match);
//    }
//
//    @Test
//    public void testSplitWordDict3() {
//        String s = "catsandog";
//        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
//        List<String> result = new ArrayList<>();
//
//        boolean match = splitWordDict(s, wordDict, result);
//        Assert.assertFalse(match);
//    }
//
//    @Test
//    public void testSplitWordDict4() {
//        String s = "catsanddog";
//        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
//        List<String> result = new ArrayList<>();
//
//        boolean match = splitWordDict(s, wordDict, result);
//        Assert.assertTrue(match);
//    }

    public void splitWordDict(String s, String[] wordDict, List<List<String>> result, int step) {

        if (s.length() == 0) {
            return;
        }

        List<String> mathedList = null;


        boolean match = false;
        for (String word : wordDict) {
            if (step == 0) {
                mathedList = new ArrayList<>();
                result.add(mathedList);
            } else {
                mathedList = result.get(result.size() - 1);
            }

            if (s.startsWith(word)) {
                mathedList.add(word);
                splitWordDict(s.substring(word.length()), wordDict, result, step + 1);
                match = true;
            }
        }

        if (!match) {
            result.remove(result.size() - 1);
        }
    }
}
