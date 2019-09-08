package com.makun.multi_mode.worker_thread;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
