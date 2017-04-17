package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "": "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime(){
        int duration = 0;
        for (Dish dish :dishes) {
            duration += dish.getDuration();
        }
        return duration;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected List<Dish> dishes = ConsoleHelper.getAllDishesForOrder();
    private final Tablet tablet;
}
