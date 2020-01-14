package com.makun.byte_demo;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        Integer[] source = new Integer[]{
                0, 1, 2, 3, 4, 5
        };
        Integer[] dest = new Integer[source.length];

        System.arraycopy(source, 0, dest, 2, 3);

        System.out.println(dest);

        System.out.println(dest[33]);


    }
}
