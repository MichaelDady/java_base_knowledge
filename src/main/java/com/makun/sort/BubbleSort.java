package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class BubbleSort {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int[] array = GetArrayUtil.getRandomArray(1000, 100);
        PrintUtil.printArray(array);
        array = bubbleSort(array);
        PrintUtil.printArray(array);
        System.out.println("Time cost(ms) : " + (System.currentTimeMillis() - startTime));
    }

    private static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
