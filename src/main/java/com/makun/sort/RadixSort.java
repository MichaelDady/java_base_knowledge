package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class RadixSort {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int[] array = GetArrayUtil.getRandomArray(1000, 100);
        PrintUtil.printArray(array);
        array = radixSort(array);
        PrintUtil.printArray(array);
        System.out.println("Time cost(ms) : " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 基数排序
     */
    private static int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int anArray : array) {
                int num = (anArray % mod) / div;
                bucketList.get(num).add(anArray);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
