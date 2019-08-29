package com.makun.multi_mode.guarded_suspension;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class ServerThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, Long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }
}
