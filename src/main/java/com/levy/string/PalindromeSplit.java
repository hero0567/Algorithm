package com.levy.string;

import org.junit.Test;

import java.util.List;

public class PalindromeSplit {

    @Test
    public void testPalindromeSplit(){
        String s = "aab";
        List<List<String>> list = palindromePartition(s);

    }

    public List<List<String>> palindromePartition(String s) {
        //TODO: DFS

        return null;
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
