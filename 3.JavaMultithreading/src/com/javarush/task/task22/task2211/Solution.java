package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* 
РЎРјРµРЅР° РєРѕРґРёСЂРѕРІРєРё
*/
public class Solution {
    static String win1251TestString = "Р СњР В°РЎР‚РЎС“РЎв‚¬Р ВµР Р…Р С‘Р Вµ Р С”Р С•Р Т‘Р С‘РЎР‚Р С•Р Р†Р С”Р С‘ Р С”Р С•Р Р…РЎРѓР С•Р В»Р С‘?"; //only for your testing

    public static void main(String[] args){
        try{

            FileInputStream input = new FileInputStream(args[0]);
            FileOutputStream out = new FileOutputStream(args[1]);


            Charset win1251 = Charset.forName("Windows-1251");
            Charset utf8 = Charset.forName("UTF-8");

            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            String s = new String(buffer, utf8);
            buffer = s.getBytes(win1251);
            out.write(buffer);
        } catch (IOException e){

        }

    }
}
