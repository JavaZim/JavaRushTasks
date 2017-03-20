package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        if(number < 0){
            number *= -1;
        }
        int length = (int) Math.log10(number)+1;
        for (int i = 0; i < length; i++) {
            int digit = number%10;
            if(digit%2 == 0 ){
                even++;
            } else {
                odd++;
            }
            number/=10;
        }

        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
