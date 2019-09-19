package com.makun.stream;

import java.util.Arrays;

/**
 * @author Created by makun
 * @Date 2019-09-09
 */
public class StreamAnalyze {
    public static void main(String[] args) {
        Arrays.asList("a", "b", "c").stream().filter(e -> !e.equals("B")).skip(2).forEach(e -> System.out.println(e));

    }

}
