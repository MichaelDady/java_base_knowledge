package com.makun.sort.util;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class GetArrayUtil {
    public static int[] getRandomArray(int size, int max) {
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(max);
        }
        return result;
    }
}
