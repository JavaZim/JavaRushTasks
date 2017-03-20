package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if(string == null){
            throw new TooShortStringException();
        }

        int begin = string.indexOf('\t')+1;
        int end = string.indexOf('\t', begin);

        if(begin == -1 || end == -1){
            throw new TooShortStringException();
        }

        return string.substring(begin, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
