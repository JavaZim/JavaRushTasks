package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<Date, Double> map = StatisticManager.getInstance().collectInformationAboutAdvertisement();
        double totalAmount = 0.0;
        for (Map.Entry<Date, Double> entry : map.entrySet()) {
            ConsoleHelper.writeMessage(String.format("$s - %.2f", format.format(entry.getKey()), entry.getValue()));
            totalAmount += entry.getValue();
        }

        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));
    }

    public void printCookWorkloading(){

        Map<Date, Map<String, Integer>> data = StatisticManager.getInstance().collectInformationAboutCook();
        for (Map.Entry<Date, Map<String, Integer>> dateMapEntry : data.entrySet()) {
            ConsoleHelper.writeMessage(format.format(dateMapEntry.getKey()));
            for (Map.Entry<String, Integer> entry : dateMapEntry.getValue().entrySet()) {
                if(entry.getValue() != 0){
                    ConsoleHelper.writeMessage(String.format("%s - %d min", entry.getKey(), entry.getValue()));
                }
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet(){


    }

    private SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
}
