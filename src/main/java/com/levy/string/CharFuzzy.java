package com.levy.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 和CharEctopic类似，和Solr的Fuzzy的近似查找类似，只有2个字母交换位置
 */
public class CharFuzzy {

    @Test
    public void testCharFuzzy() {

        Assert.assertTrue(charFuzzy("", ""));
        Assert.assertTrue(charFuzzy("anagram", "anagram"));
        Assert.assertTrue(charFuzzy("hello", "ehllo"));
        Assert.assertTrue(charFuzzy("helloword", "helloowrd"));
        Assert.assertTrue(charFuzzy("rat", "art"));

        Assert.assertFalse(charFuzzy("rat", "car"));
        Assert.assertFalse(charFuzzy("hello", "hell"));
        Assert.assertFalse(charFuzzy("hello", "healo"));

    }

    public boolean charFuzzy(String s, String t) {

        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int diffIndex = -1;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i]) {
                if (diffIndex == -1 || diffIndex == i - 1) {
                    diffIndex = diffIndex == -1 ? i : diffIndex;
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (diffIndex > -1) {
            if (ss[diffIndex] != tt[diffIndex + 1] || ss[diffIndex + 1] != tt[diffIndex]) {
                return false;
            }
        }
        return true;
    }
}
