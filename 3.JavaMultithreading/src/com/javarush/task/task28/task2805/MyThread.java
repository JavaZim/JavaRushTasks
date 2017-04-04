package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

    public MyThread() {

        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);


    }

    public MyThread(Runnable target) {
        super(target);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(String name) {
        super(name);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setMyPriority(this.getThreadGroup().getMaxPriority());
        this.setPriority(priority);
    }

    private static void setMyPriority(int max) {

        if (priority == Thread.MAX_PRIORITY) {
            priority = 1;
        } else {
            priority++;
        }
    }

    private volatile static int priority = 0;

}
