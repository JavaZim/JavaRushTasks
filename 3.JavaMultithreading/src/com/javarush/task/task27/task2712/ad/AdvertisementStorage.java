package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {

        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min 180
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min 900
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min 600
        videos.add(new Advertisement(someContent, "4", 2000, 3, 20 * 60));
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList();
}
