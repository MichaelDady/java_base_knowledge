package com.makun.sort;

import com.makun.sort.util.GetArrayUtil;
import com.makun.sort.util.PrintUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class MergSort {

    private static final Integer DEFAULT_VAL = 2;

    public static void main(String[] args) {
        HashMap map = new LinkedHashMap();
        int[] array = GetArrayUtil.getRandomArray(100, 100);
        PrintUtil.printArray(array);
        array = mergesort(array);
        PrintUtil.printArray(array);
    }

    /**
     * 归并排序
     */
    private static int[] mergesort(int[] array) {
        if (array.length < DEFAULT_VAL) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergesort(left), mergesort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
