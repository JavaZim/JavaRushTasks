package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(path.getAbsolutePath()+"/"+args[1]);

        if(!resultFileAbsolutePath.exists()){
            try{
                resultFileAbsolutePath.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

        File renamedFile = new File(resultFileAbsolutePath.getParent()+"/"+"allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, renamedFile);

        getNamesOfFiles(path);

        for (File file :listFiles) {
            if(file.length() > 50){
                FileUtils.deleteFile(file);
            }
        }

        listFiles.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {

                char[] charArray1 = o1.getName().toCharArray();
                char[] charArray2 = o2.getName().toCharArray();

                for (int i = 0; i < charArray1.length; i++) {
                    if (charArray2.length > i) {
                        if (charArray1[i] > charArray2[i]) {
                            return 1;
                        } else if (charArray1[i] < charArray2[i]) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });

        BufferedWriter writer = null;
        BufferedReader reader = null;
        try{
            if(resultFileAbsolutePath != null){
                writer = new BufferedWriter(new FileWriter(renamedFile));
                for (File file :listFiles) {
                    reader = new BufferedReader(new FileReader(file));
                    while(reader.ready()){
                        writer.write(reader.readLine());
                        writer.newLine();
                    }
                    writer.newLine();
                }
            }


        }catch (IOException e){

        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    private static void getNamesOfFiles(File direcotory) {
        for (File file : direcotory.listFiles()) {
            if (file.isDirectory()) {
                getNamesOfFiles(file);
            } else {
                listFiles.add(file);
            }
        }
    }

    private static List<File> listFiles = new ArrayList<>();
    private static List<String> listNameOfFiles = new ArrayList<>();
}
