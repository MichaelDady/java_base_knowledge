package com.makun.stream;

import java.util.function.Consumer;

/**
 * @author Created by makun
 * @Date 2019-11-08
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);
            System.out.println(a + "_");
        };
        consumer.accept(10);
    }
}
