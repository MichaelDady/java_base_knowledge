package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class BucketSort {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int[] array = GetArrayUtil.getRandomArray(1000, 100);
        PrintUtil.printArray(array);
        bucketSort(new ArrayList<>(), 10);
        PrintUtil.printArray(array);
        System.out.println("Time cost(ms) : " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 桶排序
     */
    private static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (Integer anArray1 : array) {
            if (anArray1 > max) {
                max = anArray1;
            }
            if (anArray1 < min) {
                min = anArray1;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }
        for (Integer anArray : array) {
            bucketArr.get((anArray - min) / bucketSize).add(anArray);
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                // 如果待排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (Integer aTemp : temp) {
                    resultArr.add(aTemp);
                }
            }
        }
        return resultArr;
    }
}
