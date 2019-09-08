package com.makun.multi_mode.worker_thread;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class ClientThread extends Thread {
    private final Channel channel;
    private static final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
