package com.makun.javabasic.src.com.interview.javabasic.bytecode;

public class ByteCodeSample {
    public static void main(String[] args) {
        int i = 1, j = 5;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);
        i = i++;
        System.out.println(i);
        System.out.println(++j);
    }
}
