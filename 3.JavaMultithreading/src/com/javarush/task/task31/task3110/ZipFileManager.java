package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(this.zipFile));
            InputStream inputStream = Files.newInputStream(source)){
            ZipEntry enrty = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(enrty);
            while(inputStream.available() > 0){
               zipOutputStream.write(inputStream.read());
            }
            zipOutputStream.closeEntry();
        }

    }

    private Path zipFile;
}
