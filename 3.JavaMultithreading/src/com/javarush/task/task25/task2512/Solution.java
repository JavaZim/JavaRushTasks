package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        list.add(e);
        Throwable throwable = e;
        while(throwable.getCause() != null){
            throwable = throwable.getCause();
            list.add(0, throwable);
        }

        for (Throwable th :list) {
            System.out.println(th);
        }


    }

    public static void main(String[] args) throws Exception{

        Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);

    }
}
