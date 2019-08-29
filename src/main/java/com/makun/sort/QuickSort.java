package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class QuickSort {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int[] array = GetArrayUtil.getRandomArray(1000, 100);
        PrintUtil.printArray(array);
        array = quickSort(array, 0, array.length - 1);
        PrintUtil.printArray(array);
        System.out.println("Time cost(ms) : " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 快速排序方法
     */
    private static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法——partition
     */
    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
