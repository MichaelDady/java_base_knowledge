package com.makun.multi_mode.guarded_suspension;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, Long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("NO." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
        super.run();
    }
}
