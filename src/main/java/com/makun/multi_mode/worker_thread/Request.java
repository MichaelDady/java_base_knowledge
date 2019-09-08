package com.makun.multi_mode.worker_thread;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Request {
    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    private final String name;
    private final int number;
    private static final Random random = new Random();

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override public String toString() {
        return "[ Request from " + name + " No." + number + "]";
    }
}
