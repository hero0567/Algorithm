package com.levy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        test("");
    }

    public static void test(String s){
        if (s.length() > 6){
            return;
        }
        System.out.println(s);
        s = s + "123";
        test(s);

        System.out.println(s);


    }

}
