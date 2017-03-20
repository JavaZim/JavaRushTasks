package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int [] array = new int [15];
        int left = 0;
        int right = 0;

        for (int i = 0; i < array.length; i++ ) {
            array[i] = scanner.nextInt();
            if(i == 0){
                left += array[i];
            } else if(i%2 == 0){
                left += array[i];
            } else if(i%2 == 1){
                right += array[i];
            }

        }
        if(left > right){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }




        //напишите тут ваш код
    }
}
