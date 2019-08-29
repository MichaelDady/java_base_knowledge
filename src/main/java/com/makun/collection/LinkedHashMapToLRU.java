package com.makun.collection;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/8/22
 */
public class LinkedHashMapToLRU {
    public static void main(String[] args) {

        int size = 5;

        /**
         * false, 基于插入排序
         * true, 基于访问排序
         */
        Map<String, String> map = new LinkedHashMap<String, String>(size, .75F, true) {

            @Override protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                boolean tooBig = size() > size;

                if (tooBig) {
                    System.out.println("最近最少使用的key=" + eldest.getKey());
                }
                return tooBig;
            }
        };

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        System.out.println(map.toString());

        map.put("6", "6");
        map.get("2");
        map.put("7", "7");
        map.get("4");

        System.out.println(map.toString());
    }
}
