package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow{

    public NoAvailableVideoEventDataRow(int totalDuration){

        this.totalDuration= totalDuration;
        currentDate = new Date();

    }

    private Date currentDate;
    private int totalDuration;
}
