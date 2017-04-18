package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Date, Double> collectInformationAboutAdvertisement() {
        Map<Date, Double> profit = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> videosSelectedListAmount = statisticStorage.getStorage(EventType.SELECTED_VIDEOS);
        for (EventDataRow eventDataRow : videosSelectedListAmount) {
            VideoSelectedEventDataRow event = (VideoSelectedEventDataRow) eventDataRow;
            Date date = dateToStringMidnight(event.getDate());

            if (profit.containsKey(date)) {
                profit.put(date, profit.get(event.getDate()) + event.getAmount() / 100.0);
            } else {
                profit.put(date, event.getAmount() / 100.0);
            }

        }
        return profit;
    }


    public Map<Date, Map<String, Integer>> collectInformationAboutCook() {
        Map<Date, Map<String, Integer>> workTimeCooks = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataCook = statisticStorage.getStorage(EventType.COOKED_ORDER);

        for (EventDataRow entry : eventDataCook) {
            CookedOrderEventDataRow event = (CookedOrderEventDataRow) entry;
            if (workTimeCooks.containsKey(event.getDate())) {
                if (workTimeCooks.get(event.getDate()).containsKey(event.getCookName())) {
                    workTimeCooks.get(event.getDate()).put(event.getCookName(), workTimeCooks.get(event.getDate()).get(event.getCookName()) + event.getTime());
                } else {
                    Map<String, Integer> dayWorksTime = new HashMap<>();
                    dayWorksTime.put(event.getCookName(), event.getTime());
                    workTimeCooks.put(event.getDate(), dayWorksTime);
                }
            } else {
                Map<String, Integer> dayWorksTime = new HashMap<>();
                dayWorksTime.put(event.getCookName(), event.getTime());
                workTimeCooks.put(event.getDate(), dayWorksTime);
            }
        }

        return workTimeCooks;
    }

    private StatisticManager() {
    }

    private class StatisticStorage {

        public StatisticStorage() {
            for (EventType event : EventType.values()) {
                storage.put(event, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            if (data != null) {
                storage.get(data.getType()).add(data);
            }
        }

        public List<EventDataRow> getStorage(EventType eventType) {
            return storage.get(eventType);
        }

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
    }

    private Date dateToStringMidnight(Date date) {
        GregorianCalendar roundedDate = new GregorianCalendar();
        roundedDate.setTime(date);
        roundedDate.set(Calendar.HOUR_OF_DAY, 0);
        roundedDate.set(Calendar.MINUTE, 0);
        roundedDate.set(Calendar.SECOND, 0);
        roundedDate.set(Calendar.MILLISECOND, 0);
        return roundedDate.getTime();
    }

    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();
}
