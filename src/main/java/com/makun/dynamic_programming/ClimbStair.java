package com.makun.dynamic_programming;

/**
 * @author Created by makun
 * @Date 2019/7/31
 */
public class ClimbStair {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println(climbStair(50));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static Integer climbStair(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStair(n - 1) + climbStair(n - 2);
        }
    }
}
