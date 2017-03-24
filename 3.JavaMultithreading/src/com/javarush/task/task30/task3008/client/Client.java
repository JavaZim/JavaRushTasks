package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;

/**
 * Created by jdk on 24.03.2017.
 */
public class Client {


    public class SocketThread extends Thread{

    }

    protected Connection connection;
    private volatile boolean clientConnected = false;
}
