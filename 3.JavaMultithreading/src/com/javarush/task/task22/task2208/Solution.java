package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String, String> params = new HashMap<>();
        params.put("name","Ivanov");
        params.put("country","Ukraine");
        params.put("city","Kiev");
        params.put("age",null);
        System.out.println(getQuery(params));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder builder = new StringBuilder();
        boolean flag = true;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if(entry.getValue() != null){
                if(flag){
                    builder.append(entry.getKey() + " = '" + entry.getValue() + "'");
                    flag = false;
                }else {
                    builder.append(" and " + entry.getKey() + " = '" + entry.getValue() + "'");
                }
            }
        }
        return builder.toString();
    }
}
