package com.javarush.task.task31.task3102;

import java.io.*;
import java.util.*;


/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        File path = new File(root);
        List<String> listNames = new ArrayList<>();
        Queue<File> listFiles = new LinkedList<>();
        listFiles.addAll(arrayToList(path.listFiles()));

        while (!listFiles.isEmpty()){
            File f = listFiles.poll();
            if(f.isDirectory()){
                listFiles.addAll(arrayToList(f.listFiles()));
            } else {
                listNames.add(f.getAbsoluteFile().toString());
            }
        }
        return listNames;

    }

    public static List<File> arrayToList(File [] files){
        List<File> list = new ArrayList<>();
        for (File file :files) {
            list.add(file);
        }
        return list;
    }
}
