package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * Created by jdk on 24.03.2017.
 */
public class Client {

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Message not sent");
        }
    }

    public void run() {

        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try{
            synchronized (this){
                wait();
            }
        } catch (InterruptedException e){
            ConsoleHelper.writeMessage("Error Client.run()");
            System.exit(1);
        }

        if(clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’");
            while(clientConnected){
                String message = ConsoleHelper.readString();
                if(message.equalsIgnoreCase("exit")){
                    break;
                } else {
                    if(shouldSendTextFromConsole()){
                        sendTextMessage(message);
                    }
                }

            }

        }else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

    }

    public static void main(String [] args){
        Client client = new Client();
        client.run();
    }



    public class SocketThread extends Thread {

    }

    protected Connection connection;
    private volatile boolean clientConnected = false;
}
