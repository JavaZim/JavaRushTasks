package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    public static void main(String[] args) {

        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                entry.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Can't sent message.");
        }


    }

    private static class Handler extends Thread {

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private Socket socket;
    }


    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
}
