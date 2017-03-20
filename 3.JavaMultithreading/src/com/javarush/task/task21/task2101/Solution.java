package com.javarush.task.task21.task2101;

import java.util.*;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        byte [] netAddress = new byte[4];

        for (int i = 0; i < ip.length; i++) {
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {


        List<String> list = new ArrayList<>();

        for (int i = 0; i < bytes.length; i++) {

            StringBuilder bitsBuilder = new StringBuilder();
            Integer tmp = new Integer(bytes[i]);

            if(tmp < 0){
               tmp += 256;
            }

            for (int j = 7; j >= 0 ; j--) {
                if(tmp == 0) {
                    bitsBuilder.append("0");
                } else if(tmp%2 == 0){
                    bitsBuilder.append("0");
                } else if(tmp%2 == 1 || tmp%2 == -1){
                    bitsBuilder.append("1");
                }
                tmp /= 2;
            }

           list.add(reverse(bitsBuilder));
        }

        StringBuilder bitsBuilder = new StringBuilder();

        for (String s :list) {
            bitsBuilder.append(s + " ");
        }
        System.out.println(bitsBuilder.toString().trim());

    }

    private static String reverse(StringBuilder stringBuilder){

        char [] chars = stringBuilder.toString().toCharArray();
        StringBuilder reversBuilder = new StringBuilder();

        for (int i = chars.length-1; i >= 0 ; i--) {
            reversBuilder.append(chars[i]);
        }
        return reversBuilder.toString();
    }
}
