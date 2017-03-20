package com.javarush.task.task31.task3106;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.*;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileOutputStream writer = new FileOutputStream(args[0]);
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();


        List<String> partsOfFile = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            partsOfFile.add(args[i]);
        }

        for (String s :partsOfFile) {
            Files.copy(Paths.get(s), byteOutput);
        }

        ByteArrayInputStream byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
        ZipInputStream zipInput = new ZipInputStream(byteInput);

        ZipEntry entry = zipInput.getNextEntry();
        while(entry != null){
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte [] array = new byte[1024];
            int length;

            while ((length = zipInput.read(array)) > 0){
                outputStream.write(array);
            }
            System.out.println(entry.getName());
            writer.write(outputStream.toByteArray());
            outputStream.close();
        }

        zipInput.close();
        byteInput.close();

    }
}
