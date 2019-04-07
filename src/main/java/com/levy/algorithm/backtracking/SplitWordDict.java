package com.levy.algorithm.backtracking;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class SplitWordDict {

    @Test
    public void testSplitWordDict(){
        String s = "applepenapple";
        String[] wordDict = {"apple", "pen"};

        boolean match = splitWordDict(s, wordDict);
        Assert.assertTrue(match);
    }

    @Test
    public void testSplitWordDict1(){
        String s = "helloworld";
        String[] wordDict = {"hello", "world"};

        boolean match = splitWordDict(s, wordDict);
        Assert.assertTrue(match);
    }

    @Test
    public void testSplitWordDict2(){
        String s = "abc";
        String[] wordDict = {"abc", "bcd"};

        boolean match = splitWordDict(s, wordDict);
        Assert.assertTrue(match);
    }

    @Test
    public void testSplitWordDict3(){
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};

        boolean match = splitWordDict(s, wordDict);
        Assert.assertFalse(match);
    }

    @Test
    public void testSplitWordDict4(){
        String s = "catsanddog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};

        boolean match = splitWordDict(s, wordDict);
        Assert.assertTrue(match);
    }


    public boolean splitWordDict(String s, String[] wordDict){
        for (String word : wordDict){
            if (s.startsWith(word)){
                if(s.equals(word)){
                    return true;
                }
                return splitWordDict(s.substring(word.length()), wordDict);
            }
        }
        return false;
    }
}
