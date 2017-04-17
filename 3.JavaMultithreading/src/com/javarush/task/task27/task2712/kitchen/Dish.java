package com.javarush.task.task27.task2712.kitchen;

public enum Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Dish.values().length; i++) {
            builder.append(Dish.values()[i] + " ");
        }

        return builder.toString().trim();

    }

    public int getDuration() {
        return duration;
    }

    private int duration;

}
