package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data){

    }

    private StatisticManager() {
    }

    private class StatisticStorage{

        public StatisticStorage() {
            for (EventType event : EventType.values()) {
                storage.put(event, new ArrayList<>());
            }
        }

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();
    }

    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
}
