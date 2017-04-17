package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        writeMessage(Dish.allDishesToString());
        List<Dish> list = new ArrayList<>();
        String dish = null;

        while (true) {

            dish = reader.readLine();
            if (dish.equals("exit")) {
                break;
            } else {
                try{
                    list.add(Dish.valueOf(dish));
                }catch (IllegalArgumentException e){
                    writeMessage("Dish does not exist in our menu. Try again, gavno");
                    continue;
                }
            }
        }
        return list;
    }

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

}
