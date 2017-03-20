package com.javarush.task.task22.task2209;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String [] input = null;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            input = reader.readLine().split(" ");
        }
        reader.close();
        StringBuilder result = getLine(input);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        Queue<String> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < words.length ; i++) {
            queue.add(words[i]);
        }

        while (!queue.isEmpty()){

            if(builder.length() == 0){
                builder.append(queue.poll());
            }

            char first = Character.toLowerCase(builder.charAt(0));
            char last = Character.toLowerCase(builder.charAt(builder.length()-1));

            char cFirst = Character.toLowerCase(queue.peek().charAt(0));
            char cLast = Character.toLowerCase(queue.peek().charAt(queue.peek().length()-1));

            if(cLast == first){
                builder.insert(0, queue.poll() + " ");

            }else if(cFirst == last){
                builder.append(" " + queue.poll());
            }else {
                queue.add(queue.poll());
            }

            if(words.length * 5 == count){
                builder.append(queue.poll());
            }

            count++;
        }
        return builder;
    }
}
