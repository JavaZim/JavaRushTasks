package com.javarush.task.task26.task2611;

import java.util.concurrent.*;

/**
 * Created by jdk on 23.03.2017.
 */
public class Producer implements Runnable{

    public Producer(ConcurrentHashMap<String, String> map){
        this.map = map;
    }

    @Override
    public void run() {
        int count = 0;

        while (true){
            count++;
            map.put(new String(count + "" ), String.format("Some text for %d", count));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
            }
        }

    }

    private ConcurrentHashMap<String, String> map;
}
