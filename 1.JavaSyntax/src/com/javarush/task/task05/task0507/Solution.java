package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        double count = 0;
        while (true){
            int number = scanner.nextInt();
            if(number == -1){
                break;
            } else {
                ++count;
                sum += number;
            }
        }
        System.out.println(sum/count);

    }
}

