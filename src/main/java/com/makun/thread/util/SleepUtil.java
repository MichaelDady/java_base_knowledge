package com.makun.thread.util;

/**
 * @author Created by makun
 * @Date 2019/8/27
 */
public class SleepUtil {
    public static void second(Integer time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
