package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class ShellSort {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int[] array = GetArrayUtil.getRandomArray(1000, 100);
        PrintUtil.printArray(array);
        array = shellSort(array);
        PrintUtil.printArray(array);
        System.out.println("Time cost(ms) : " + (System.currentTimeMillis() - startTime));
    }

    private static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
