package com.levy.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;


public class BackTracking {

    /**
     * 一、给出n对括号，求括号排列的所有可能性。
     */
    @Test
    public void testParentheses() {
        int n = 3;
        int leftnum = n, rightnum = n;//左括号和右括号都各有n个
        ArrayList<String> results = new ArrayList<String>();//用于存放解空间
        parentheses("", results, leftnum, rightnum);
        for (String s : results)
            System.out.println(s);
    }

    public static void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum) {
        if (leftnum == 0 && rightnum == 0)//结束
            results.add(sublist);
        if (rightnum > leftnum)//选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
            parentheses(sublist + ")", results, leftnum, rightnum - 1);
        if (leftnum > 0)
            parentheses(sublist + "(", results, leftnum - 1, rightnum);
    }


    /**
     * 三、给一个字符串，给出他的所有排列
     */
    @Test
    public  void testPermutation(){
        String s="abc";
        permutation(s,"");
    }

    public static void permutation(String s, String temp){//参数设计地尽量地简洁
        if(s.length()==0){
            System.out.println(temp);
            return;
        }
        for(int i=0;i<s.length();i++){
            String news=s.substring(0, i)+s.substring(i+1,s.length());//去掉String中的某个字母
            permutation(news, temp+s.charAt(i));
        }
    }
}