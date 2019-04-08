package com.levy.string;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class CharEctopic {


    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    @BeforeClass
    public static void beforeClass() {
    }

    @Test
    public void testCharEctopicByPrime() {

        Assert.assertTrue(charEctopicByPrime("", ""));
        Assert.assertTrue(charEctopicByPrime("anagram", "anagram"));
        Assert.assertTrue(charEctopicByPrime("hello", "ehllo"));
        Assert.assertTrue(charEctopicByPrime("helloword", "helloowrd"));
        Assert.assertTrue(charEctopicByPrime("rat", "art"));
        Assert.assertTrue(charEctopicByPrime("rat", "tar"));

        Assert.assertFalse(charEctopicByPrime("rat", "car"));
        Assert.assertFalse(charEctopicByPrime("hello", "hell"));
        Assert.assertFalse(charEctopicByPrime("hello", "healo"));

    }

    @Test
    public void testCharEctopic() {

        Assert.assertTrue(charEctopic("", ""));
        Assert.assertTrue(charEctopic("anagram", "anagram"));
        Assert.assertTrue(charEctopic("hello", "ehllo"));
        Assert.assertTrue(charEctopic("helloword", "helloowrd"));
        Assert.assertTrue(charEctopic("rat", "art"));
        Assert.assertTrue(charEctopic("rat", "tar"));

        Assert.assertFalse(charEctopic("rat", "car"));
        Assert.assertFalse(charEctopic("hello", "hell"));
        Assert.assertFalse(charEctopic("hello", "healo"));

    }

    /**
     * 通过质数的特性，每个字母对应一个质数，相同的字符串则乘机相等
     */
    public boolean charEctopicByPrime(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int sc = 1, tc = 1;
        for (int i = 0; i < ss.length; i++) {
            sc = sc * prime[ss[i] - 97];
            tc = tc * prime[tt[i] - 97];
        }
        if (sc != tc) {
            return false;
        }
        return true;
    }

    /**
     * 把所有的字母放在26个字母对应的位置，一个++，一个--，如果存在同样多的同一个字母，结果为0
     * 判断数组的所有结果为0，则2个数组的字母是异位
     */
    public boolean charEctopic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
