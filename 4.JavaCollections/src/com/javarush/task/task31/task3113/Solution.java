package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(scanner.next());

        if(Files.isDirectory(path)){
            Files.walkFileTree(path, new FileVisitor<Path>(){

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    countDirecories++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countBytes += Files.size(file);
                    countFiles++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    countBytes += Files.size(file);
                    countFiles++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.printf("Всего папок - %s", countDirecories - 1);
            System.out.println();
            System.out.printf("Всего файлов - %s", countFiles);
            System.out.println();
            System.out.printf("Общий размер - %s", countBytes);

        } else {
            System.out.printf("%s - не папка",path.toAbsolutePath().toString());
        }
    }

    private static long countBytes;
    private static int countFiles;
    private static int countDirecories;
}
