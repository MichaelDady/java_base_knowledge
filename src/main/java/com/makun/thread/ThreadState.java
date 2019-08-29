package com.makun.thread;

import com.makun.thread.util.SleepUtil;

/**
 * @author Created by makun
 * @Date 2019/8/27
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaiting").start();
        new Thread(new Waiting(), "Waiting").start();
        new Thread(new Blocked(), "Blocked1").start();
        new Thread(new Blocked(), "Blocked2").start();
    }

    static class TimeWaiting implements Runnable {
        @Override public void run() {
            while (true) {
                SleepUtil.second(100);
            }
        }
    }


    static class Waiting implements Runnable {
        @Override public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (Exception e) {

                    }
                }
            }
        }
    }


    static class Blocked implements Runnable {
        @Override public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtil.second(100);
                }
            }
        }
    }
}
