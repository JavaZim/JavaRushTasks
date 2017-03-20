package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.*;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        Path pathToZip = Paths.get(args[1]);

        FileInputStream firstStream = new FileInputStream(args[1]);
        ZipInputStream zipInputStream = new ZipInputStream(firstStream);
        ZipEntry entry = null;
        Map<String, OutputStream> zipsMap = new HashMap<>();

        while ((entry = zipInputStream.getNextEntry()) != null) {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte [] array = new byte[1024];
            int length;

            while ((length = zipInputStream.read(array)) > 0){
                outputStream.write(array);
            }
            System.out.println(entry.getName());
            zipsMap.put(entry.getName(), outputStream);
        }

        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        ZipEntry newEntry = new ZipEntry("new" + File.separator + path.getFileName().toString());
        zipOutputStream.putNextEntry(newEntry);

        Files.copy(path, zipOutputStream);

        for (Map.Entry<String, OutputStream> mapEntry : zipsMap.entrySet()) {

            if(!(mapEntry.getKey().equals(newEntry.getName()))){
                ZipEntry z = new ZipEntry(mapEntry.getKey());
                zipOutputStream.putNextEntry(z);
                ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) mapEntry.getValue();
                zipOutputStream.write(byteArrayOutputStream.toByteArray());
                mapEntry.getValue().close();
            }
        }
        zipOutputStream.close();


    }
}
