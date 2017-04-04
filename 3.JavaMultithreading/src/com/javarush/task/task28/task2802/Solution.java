package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{

        public AmigoThreadFactory(){
            groupNumber.getAndIncrement();
            group = groupNumber.get();
        }


        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            threadNumber.getAndIncrement();
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            String gn = thread.getThreadGroup().getName();
            thread.setName(String.format("%s-pool-%d-thread-%d", gn, group, threadNumber.get()));
            return thread;
        }
        private AtomicInteger threadNumber = new AtomicInteger(0);
        private static AtomicInteger groupNumber = new AtomicInteger(0);
        private int group = 0;
    }


}
