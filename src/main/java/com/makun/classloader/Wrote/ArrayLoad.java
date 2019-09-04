package com.makun.classloader.Wrote;

/**
 * @author Created by makun
 * @Date 2019/8/29
 */
public class ArrayLoad {

    public static void main(String[] args) {

        Bird[] birds = new Bird[10];
        Integer[] integerArr = new Integer[10];
        int[] intArr = new int[10];
//        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        new  Bird();
        System.out.println(birds.getClass().getClassLoader());
        System.out.println(integerArr.getClass().getClassLoader());
        System.out.println(intArr.getClass().getClassLoader());
    }
}
