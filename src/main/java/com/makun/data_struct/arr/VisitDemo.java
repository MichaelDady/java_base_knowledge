package com.makun.data_struct.arr;

import java.util.*;

public class VisitDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int num = 100000000;
        int[] arr = new int[num];

        int[] order = new int[num];

        int k ;
        for (int i = 0; i < num; i++) {
            arr[i] = i;
            order[i] = random.nextInt(num);
        }


        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < num ; i++) {
            k = arr[order[i]];
        }
        System.out.println(System.currentTimeMillis() - startTime);


        startTime = System.currentTimeMillis();
        for (int i = 0; i < num * 1000; i++) {
            k = arr[order[0]];
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
