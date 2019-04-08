package com.levy.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {

    @Test
    public void testFindFirstUniqChar() {
        Assert.assertEquals('h', findFirstUniqChar("hello"));
        Assert.assertEquals(-1, findFirstUniqChar("abcabc"));
        Assert.assertEquals('d', findFirstUniqChar("abcdabc"));
        Assert.assertEquals('y', findFirstUniqChar("xyzzx"));
    }

    public int findFirstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return -1;
    }
}



