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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while(true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(MessageType.USER_NAME == message.getType()){

                    String nameUser = message.getData();
                    if(nameUser.length() != 0 && !connectionMap.containsKey(nameUser)){
                        connectionMap.put(nameUser, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return nameUser;
                    }

                }
            }

        }

        private void sendListOfUsers(Connection connection, String userName)throws IOException{
            for (Map.Entry<String, Connection> entry :connectionMap.entrySet()) {
                if(!entry.getKey().equals(userName)){
                    Message message = new Message(MessageType.USER_ADDED, entry.getKey());
                    connection.send(message);
                } else {
                    System.out.println("Error");
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    Message confMessage = new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData()));
                    sendBroadcastMessage(confMessage);
                }
            }
        }

        private Socket socket;
    }


    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
}
