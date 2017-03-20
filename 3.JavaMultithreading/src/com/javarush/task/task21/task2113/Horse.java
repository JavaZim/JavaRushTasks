package com.javarush.task.task21.task2113;

import java.util.Random;

/**
 * Created by jdk on 28.02.2017.
 */
public class Horse {

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
        distance += speed * Math.random();
    }

    public void print(){
        for (int i = 1; i <= distance; i++) {
            System.out.print(".");
        }
        System.out.println(name);
    }

    private String name;
    private double speed;
    private double distance;
}
