package com.javarush.task.task29.task2909.car;

public class Sedan extends Car{
    public Sedan(int numberOfPassengers) {
        super(numberOfPassengers);
    }

    public int getMaxSpeed(){
        return MAX_SEDAN_SPEED;
    }

    public static final int MAX_SEDAN_SPEED = 120;
}
