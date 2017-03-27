package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jdk on 27.03.2017.
 */
public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String data = "date_bot_" + (int) (Math.random() * 100);
        return data;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage(MESSAGE);
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            String nameUser = null;
            String messageData;
            SimpleDateFormat format = null;

            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")) {
                nameUser = message.substring(0, message.indexOf(": "));
                messageData = message.substring(message.indexOf(": ") + 2);
            } else {
                messageData = message;
            }

            if (messageData.equalsIgnoreCase("дата")) {
                format = new SimpleDateFormat("d.MM.YYYY");
            } else if (messageData.equalsIgnoreCase("день")) {
                format = new SimpleDateFormat("d");
            } else if (messageData.equalsIgnoreCase("месяц")) {
                format = new SimpleDateFormat("MMMM");
            } else if (messageData.equalsIgnoreCase("год")) {
                format = new SimpleDateFormat("YYYY");
            } else if (messageData.equalsIgnoreCase("время")) {
                format = new SimpleDateFormat("H:mm:ss");
            } else if (messageData.equalsIgnoreCase("час")) {
                format = new SimpleDateFormat("H");
            } else if (messageData.equalsIgnoreCase("минуты")) {
                format = new SimpleDateFormat("m");
            } else if (messageData.equalsIgnoreCase("секунды")) {
                format = new SimpleDateFormat("s");
            }

            if (format != null) {
                sendTextMessage(String.format("Информация для %s: %s", nameUser, format.format(Calendar.getInstance().getTime())));
            }
        }
    }

    private final static String MESSAGE = "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";

}
