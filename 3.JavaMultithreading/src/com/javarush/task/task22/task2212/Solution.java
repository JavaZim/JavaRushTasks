package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if(telNumber == null || telNumber.length() < 10){
            return false;
        }

        if (telNumber.charAt(0) != '+') {
            if(telNumber.replaceAll("\\D","").length() == 10){
                if(telNumber.matches("\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+")){
                    return true;
                }
            }
        }

        if (telNumber.charAt(0) == '+') {
            if(telNumber.replaceAll("\\D","").length() == 12){
                if(telNumber.matches("\\+\\d*(\\(\\d{3}\\))?\\d*(-\\d+)?(-?\\d+)?")){
                    return true;
                }
            }
        }
        return false;
    }

    public static void testNumber(String number, boolean expected)
    {
        boolean result = checkTelNumber(number);
        System.out.format("%s:\t%s\t%b\t%b\n", (result == expected ? "OK" : "Fail"), number, result ,expected);
    }
    public static void main(String[] args)
    {
        testNumber(null, false);
        testNumber("", false);
        testNumber("+380501234567", true);
        testNumber("+3805012345q67", false);
        testNumber("+3805012345 67", false);
        testNumber("+3805012345.67", false);
        testNumber("+3805012345,67", false);
        testNumber("1-23456789-0", true);
        testNumber("1-23(456)789-0", false);
        testNumber("1-234567(89-0)", false);
        testNumber("1-2345678(9-0)", false);
        testNumber("(1-2)3456789-0", false);
        testNumber("+38051202(345)-7", true);
        testNumber("(345)0512027", true);
        testNumber("+-313450531202", true);
        testNumber("+-313450531202-", false);
        testNumber("+380501212334567", false);
        testNumber("+3805012asd34567", false);
        testNumber("+38(050)1234567", true);
        testNumber("+38(150)1234567", true);
        testNumber("+3+8(050)1234567", false);
        testNumber("+38(050)12-34-567", true);
        testNumber("+38(050)12-34567", true);
        testNumber("+38(050)112-34567", false);
        testNumber("+38(050)12-34(5)67", false);
        testNumber("+3(8)(050)12-34567", false);
        testNumber("+38050123-45-67", true);
        testNumber("+38050123-45-6789", false);
        testNumber("050123-4567", true);
        testNumber("050123-45678", false);
        testNumber("+38)050(1234567", false);
        testNumber("+38(050)1-23-45-6-7", false);
        testNumber("050ххх4567", false);
        testNumber("050123456", false);
        testNumber("(0)501234567", false);
        testNumber("+38-(050)1234567", false);
        testNumber("38-(050)34567", false);
        testNumber("-38-(050)34567", false);
        testNumber("38-(050)34567-", false);
        testNumber("38(050)3(45)67", false);
        testNumber("(380)(050)3567", false);
        testNumber("+38(380)(050)3567", false);
        testNumber("8(380)(050)367", false);
        testNumber("8(380)4(050)67", false);
        testNumber("+38((050)1234567", false);
        testNumber("+5(0--5)1234567", false);
        testNumber("7-4-4123689-5", false);
        testNumber("+(012)123456789", true);
        testNumber("+(012)1-2345678-9", true);
        testNumber("+(012)-12345678-9", true);
        testNumber("+(012)-1-23456789", true);
        testNumber("+(012)1234567", false);
        testNumber("+(01-2)123456789", false);
        testNumber("+(012)12345678--9", false);
        testNumber("+(012)--123456789", false);
    }
}
