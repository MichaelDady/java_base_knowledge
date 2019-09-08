package com.makun.multi_mode.worker_thread;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bob", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
