package com.javarush.task.task07.task0712;

import java.util.*;
import java.io.*;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String maxString = "";
        int maxIndex = 0;
        String minString = "";
        int minIndex = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            if(i == 0){
                maxString = list.get(i);
                minString = list.get(i);
            } else {
                if(maxString.length() < list.get(i).length()){
                    maxString = list.get(i);
                    maxIndex = i;
                }
                if(minString.length() > list.get(i).length()){
                    minString = list.get(i);
                    minIndex = i;
                }
            }

        }
        reader.close();

        if(maxIndex < minIndex){
            System.out.println(maxString);
        } else {
            System.out.println(minString);
        }

        //напишите тут ваш код
    }
}
