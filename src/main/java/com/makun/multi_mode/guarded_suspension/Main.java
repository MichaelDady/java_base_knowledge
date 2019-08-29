package com.makun.multi_mode.guarded_suspension;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"Alice", 20393L).start();
        new ServerThread(queue,"Bob", 65789L).start();
    }
}
