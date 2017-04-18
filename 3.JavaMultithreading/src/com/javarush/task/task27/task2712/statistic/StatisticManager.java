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
            Date date = dateToStringMidnight(event.getDate());
            if (workTimeCooks.containsKey(date)) {
                if (workTimeCooks.get(date).containsKey(event.getCookName())) {
                    workTimeCooks.get(date).put(event.getCookName(), workTimeCooks.get(date).get(event.getCookName()) + event.getTime());
                } else {
                    workTimeCooks.get(date).put(event.getCookName(), event.getTime());
                }
            } else {
                Map<String, Integer> dayWorksTime = new TreeMap<>();
                dayWorksTime.put(event.getCookName(), event.getTime());
                workTimeCooks.put(date, dayWorksTime);
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

             /*
            List<Advertisement> firstList = new ArrayList<>();
            List<Advertisement> seconftList = new ArrayList<>();
            List<Advertisement> thirdtList = new ArrayList<>();
            firstList.add(AdvertisementStorage.getInstance().list().get(0));
            seconftList.add(AdvertisementStorage.getInstance().list().get(0));
            seconftList.add(AdvertisementStorage.getInstance().list().get(1));
            thirdtList.add(AdvertisementStorage.getInstance().list().get(0));
            thirdtList.add(AdvertisementStorage.getInstance().list().get(2));
            thirdtList.add(AdvertisementStorage.getInstance().list().get(1));


            storage.get(EventType.SELECTED_VIDEOS).add(new VideoSelectedEventDataRow(firstList, 5000, 180, new Date(1000, 04, 15)));
            storage.get(EventType.SELECTED_VIDEOS).add(new VideoSelectedEventDataRow(seconftList, 5100, 1080, new Date(1000, 04, 15)));
            storage.get(EventType.SELECTED_VIDEOS).add(new VideoSelectedEventDataRow(thirdtList, 5500, 1680, new Date(1000, 04, 15)));



            List<Dish> firstList = new ArrayList<>();
            List<Dish> seconftList = new ArrayList<>();
            List<Dish> thirdtList = new ArrayList<>();
            firstList.add(Dish.Fish);
            seconftList.add(Dish.Steak);
            seconftList.add(Dish.Soup);
            thirdtList.add(Dish.Fish);
            thirdtList.add(Dish.Juice);
            thirdtList.add(Dish.Steak);

            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=5}", "NoAmigo", 1500, firstList, new Date(17, 3, 15)));
            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=6}", "Karlo", 2700, seconftList, new Date(17, 3, 15)));
            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=7}", "Red", 3600, thirdtList, new Date(17, 3, 15)));

            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=5}", "NoAmigo", 25*60, firstList, new Date(17, 3, 16)));
            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=5}", "NoAmigo", 60*60, thirdtList, new Date(17, 3, 16)));
            storage.get(EventType.COOKED_ORDER).add(new CookedOrderEventDataRow("Tablet{number=6}", "Karlo", 45*60, seconftList, new Date(17, 3, 16)));
            */


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
