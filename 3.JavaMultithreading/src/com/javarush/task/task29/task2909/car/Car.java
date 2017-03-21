package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Car(int numberOfPassengers){
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int countOfPassengers) {

        switch (type){
            case 0: return new Truck(countOfPassengers);
            case 1: return new Sedan(countOfPassengers);
            case 2: return new Cabriolet(countOfPassengers);
            default: return  null;
        }

    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
             throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        if(isSummer(date, SummerStart, SummerEnd)){
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }

    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){

        if(date.getTime() - summerStart.getTime() >= 0 && date.getTime() - summerEnd.getTime() <= 0){
            return true;
        } else {
            return false;
        }
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred(){
        if(isDriverAvailable() && fuel > 0){
            return true;
        } else
            return false;
    }
}