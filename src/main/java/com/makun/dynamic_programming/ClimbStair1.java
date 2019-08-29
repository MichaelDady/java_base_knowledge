package com.makun.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by makun
 * @Date 2019/7/31
 */
public class ClimbStair1 {
    private static Map<Long, Long> map = new HashMap<>();

    static {
        map.put(1L, 1L);
        map.put(2L, 2L);
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println(climbStair(60));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static Long climbStair(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long sum = climbStair(n - 1) + climbStair(n - 2);
            map.put(n, sum);
            return sum;
        }
    }
}
