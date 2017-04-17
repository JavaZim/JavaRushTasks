package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data){

    }

    private StatisticManager() {
    }

    private static StatisticManager ourInstance = new StatisticManager();
}
