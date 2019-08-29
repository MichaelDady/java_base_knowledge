package com.makun.io;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // javac MergeSort.java && java MergeSort
        int[] data = {
                2, 1, 9, 7, 4, 6, 5, 10, 21, 0
        };
        print(data);
        int[] tmp = new int[data.length];
        mergeSort(data, tmp, 0, data.length - 1);
        System.out.println();
        print(data);
    }

    private static void mergeSort(int[] data, int[] tmp, int low, int high) {
        if (high > low) {
            int middle = (low + high) / 2;
            mergeSort(data, tmp, low, middle);
            mergeSort(data, tmp, middle + 1, high);
            merge(data, tmp, low, middle, high);
        }
    }

    private static void merge(int[] data, int[] tmp, int low, int middle, int high) {
        int i = low, j = middle + 1;
        int k = low;
        while ((i <= middle) && (j <= high)) {
            if (data[i] < data[j]) {
                tmp[k] = data[i];
                i++;
            } else {
                tmp[k] = data[j];
                j++;
            }
            k++;
        }
        if (i <= middle) {
            for (; i <= middle; i++) {
                tmp[k] = data[i];
                k++;
            }
        }

        if (j <= high) {
            for (; j <= high; j++) {
                tmp[k] = data[j];
                k++;
            }
        }

        for (i = low; i <= high; i++) {
            data[i] = tmp[i];
        }

    }


    /**
     * 打印数组
     */
    private static void print(int[] a) {
        for (int anA : a) {
            System.out.print(anA + ", ");
        }
    }
}

