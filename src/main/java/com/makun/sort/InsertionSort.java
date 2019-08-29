package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = GetArrayUtil.getRandomArray(100, 100);
        PrintUtil.printArray(array);
        array = insertionSort(array);
        PrintUtil.printArray(array);
    }


    private static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
