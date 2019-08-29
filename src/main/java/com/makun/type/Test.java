package com.makun.type;

/**
 * @author Created by makun
 * @Date 2019/8/19
 */
public class Test {
    public static void main(String[] args) {
        Comparable<String> a = min("cat", "dog");
        Comparable<Integer> b = min(new Integer(10), new Integer(3));
        String str = Fmin("cat", "dog");
        Integer i = Fmin(new Integer(10), new Integer(3));
    }

    public static <S extends Comparable> S min(S a, S b) {
        if (a.compareTo(b) <= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static <T extends Comparable<T>> T Fmin(T a, T b) {
        if (a.compareTo(b) <= 0) {
            return a;
        } else {
            return b;
        }
    }
}
