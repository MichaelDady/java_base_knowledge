package com.makun.classloader.mine;

/**
 * @author kun.ma on 2019/8/24
 */
public class MyTest15 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr.getClass().getClassLoader());

        String[] arr1 = new String[3] ;
        System.out.println(arr1.getClass().getClassLoader());

        MyTest15[] arr2 = new MyTest15[3];
        System.out.println(arr2.getClass().getClassLoader());
    }
}
