package com.makun.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019-09-30
 */
public class ListVisitPerformanceCompare {
    public static void main(String[] args) {
        int totalNum = 10000;
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        int[] idxArr = new int[totalNum];
        Random random = new Random();
        for (int i = 0; i < totalNum; i++) {
            int randInt = random.nextInt();
            idxArr[i] = random.nextInt(totalNum);
            arrList.add(randInt);
            linkList.add(randInt);
        }
        calGetTimeCost(arrList, idxArr);
        calGetTimeCost(linkList, idxArr);
    }

    private static void calGetTimeCost(List<Integer> arrList, int[] idxArr) {
        int len = idxArr.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            arrList.get(idxArr[i]);
        }
        System.out.println("在集合 ：" + arrList.getClass().getName() + "下随机抽取" + len + "条数据，耗时："
                + (System.currentTimeMillis() - startTime) + "ms");
    }
}
