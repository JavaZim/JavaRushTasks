package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow{

    public NoAvailableVideoEventDataRow(int totalDuration){

        this.totalDuration= totalDuration;
        currentDate = new Date();

    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    private Date currentDate;
    private int totalDuration;
}
