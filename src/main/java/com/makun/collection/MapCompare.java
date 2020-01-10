package com.makun.collection;

import java.util.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapCompare {
    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            randomList.add(random.nextInt());
        }

        printTimeCost(new ConcurrentHashMap<>(), randomList);
        printTimeCost(new ConcurrentSkipListMap<>(), randomList);
    }

    private static void printTimeCost(Map<Integer, Integer> map, List<Integer> list) {
        Long startTime = System.currentTimeMillis();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            map.put(i, i);
        }
        System.out.println("Cost of time : " + (System.currentTimeMillis() - startTime));
    }
}
