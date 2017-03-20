package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    private static List<String>  words = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.next()) ;
        scanner.close();

        try {
            List<String> list = Files.readAllLines(file.toPath());

            for (String line : list) {
                String [] lineWords = line.split("\\s");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < words.size(); i++) {

            String current = words.get(i);
            words.set(i, null);
            if(current == null){
                continue;
            }
            StringBuilder builder = new StringBuilder(current);
            builder.reverse();
            if(words.contains(builder.toString())){
                Pair pair = new Pair();
                pair.first = builder.toString();
                pair.second = builder.reverse().toString();
                result.add(pair);
                words.set(words.indexOf(pair.first), null);
            }
        }

        for (Pair pair :result) {
            System.out.println(pair);
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
