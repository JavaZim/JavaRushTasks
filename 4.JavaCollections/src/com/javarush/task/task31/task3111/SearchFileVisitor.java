package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {


        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles(){
        return  null;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public String getGetPartOfContent() {
        return PartOfContent;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public long getMinSize() {
        return minSize;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String getPartOfContent) {
        this.PartOfContent = getPartOfContent;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(long minSize) {
        this.minSize = minSize;
    }

    private String partOfName;
    private String PartOfContent;
    private long maxSize;
    private long minSize;
}
