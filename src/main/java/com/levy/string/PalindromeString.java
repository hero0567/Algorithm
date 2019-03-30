package com.levy.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class PalindromeString {

    @Test
    public void testCheckIsPalindrome() {
        String s = "A man, a plan, a canal: Panama";
        Assert.assertTrue(checkIsPalindrome(s));

        s = "A man, a pldan, a canal: Panama";
        Assert.assertFalse(checkIsPalindrome(s));

        s = "race a car";
        Assert.assertFalse(checkIsPalindrome(s));

        s = "race 11e car";
        Assert.assertTrue(checkIsPalindrome(s));

        s = "a";
        Assert.assertTrue(checkIsPalindrome(s));

        s = "";
        Assert.assertTrue(checkIsPalindrome(s));
    }

    public boolean checkIsPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            while (!Character.isLetterOrDigit(chars[start])) {
                start++;
            }
            while (!Character.isLetterOrDigit(chars[end])) {
                end--;
            }

            //all left equal right
            if (start > end) {
                return true;
            }
            char left = chars[start];
            char right = chars[end];
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
