package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public static long getProvePermutation(int totalTime, List<Advertisement> videoStorage, int storageSize, ArrayList<Advertisement> resultVideoList) {
        if (storageSize == 0 || totalTime == 0)
            return 0;
        if (videoStorage.get(storageSize - 1).getHits() < 1 || videoStorage.get(storageSize - 1).getDuration() > totalTime)
            return getProvePermutation(totalTime, videoStorage, storageSize - 1, resultVideoList);
        else {
            final int preTookSize = resultVideoList.size();
            final long took = videoStorage.get(storageSize - 1).getAmountPerOneDisplaying() + getProvePermutation(totalTime - videoStorage.get(storageSize - 1).getDuration(), videoStorage, storageSize - 1, resultVideoList);
            final int preLeftSize = resultVideoList.size();
            final long left = getProvePermutation(totalTime, videoStorage, storageSize - 1, resultVideoList);
            if (took > left) {
                if (resultVideoList.size() > preLeftSize)
                    resultVideoList.subList(preLeftSize, resultVideoList.size()).clear();
                resultVideoList.add(videoStorage.get(storageSize - 1));
                return took;
            } else {
                if (preLeftSize > preTookSize)
                    resultVideoList.subList(preTookSize, preLeftSize).clear();
                return left;
            }
        }
    }

    public void processVideos() {
        List<Advertisement> videosStorage = storage.list();
        int storageSize = videosStorage.size();
        ArrayList<Advertisement> resultVideoList = new ArrayList<>(); // итоговый массив к показу
        int totalTime = timeSeconds;
        getProvePermutation(totalTime, videosStorage, storageSize, resultVideoList);
        if (resultVideoList.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(resultVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long result = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (result == 0)
                    result = (long) (o1.getAmountPerOneDisplaying() * 1000.0 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000.0 / o2.getDuration());
                return (int) result;
            }
        });
        
        for (Advertisement x : resultVideoList) {
            ConsoleHelper.writeMessage(x.getName() + " is displaying... " + x.getAmountPerOneDisplaying() + ", " + x.getAmountPerOneDisplaying() * 1000 / x.getDuration());
            x.revalidate();
        }
    }

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
}
