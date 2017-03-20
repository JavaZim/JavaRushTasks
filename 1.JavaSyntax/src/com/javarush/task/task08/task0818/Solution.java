package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Pipirka #" + i, (int)(Math.random()*1000));
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        List<String> key = new ArrayList<>();
        for (Map.Entry<String, Integer> entry :map.entrySet()) {
            if(entry.getValue() < 500){
                key.add(entry.getKey());
            }

        }
        for (String s :key) {
            map.remove(s);
        }

    }

    public static void main(String[] args) {

        removeItemFromMap(createMap());

    }
}