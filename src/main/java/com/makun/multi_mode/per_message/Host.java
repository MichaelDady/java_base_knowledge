package com.makun.multi_mode.per_message;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("Request " + count + " " + c + " begin...");
        new Thread(() -> helper.handle(count, c)).start();
        System.out.println("Request " + count + " " + c + " end...");
    }
}
