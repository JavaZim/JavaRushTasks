package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        String [] s = getTokens("level22.lesson13.task01", ".");
        for (String s1 :s) {
            System.out.println(s1);
        }


    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer token = new StringTokenizer(query, delimiter);
        String [] output = new String[token.countTokens()];
        int i = 0;
        while (token.hasMoreElements()){
            output[i] = token.nextToken();
            i++;
        }
        return output;
    }
}
