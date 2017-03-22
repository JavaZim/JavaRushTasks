package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.DoubleAdder;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {

        if(array.length == 0){
            return array;
        }
        Arrays.sort(array);
        System.out.println();
        double mediana;

        if(array.length%2 == 0){
            mediana = array[array.length/2]/2.0 + array[array.length/2-1]/2.0;
        } else {
            mediana = array[array.length/2];
        }

        System.out.println(mediana);


        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(Math.abs(o1 - mediana), Math.abs(o2 - mediana));
            }
        });

        return array;
    }
}
