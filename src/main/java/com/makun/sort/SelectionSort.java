package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = GetArrayUtil.getRandomArray(100, 100);
        PrintUtil.printArray(array);
        array = selectionSort(array);
        PrintUtil.printArray(array);
    }

    private static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    //找到最小的数
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
