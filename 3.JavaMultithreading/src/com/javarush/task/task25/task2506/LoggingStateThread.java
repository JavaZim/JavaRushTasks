package com.javarush.task.task25.task2506;

/**
 * Created by jdk on 16.03.2017.
 */
public class LoggingStateThread extends Thread {

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }

    private Thread thread;
}
