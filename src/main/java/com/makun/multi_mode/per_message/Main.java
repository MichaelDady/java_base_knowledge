package com.makun.multi_mode.per_message;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        host.request(10, 'A');
        host.request(10, 'B');
        host.request(10, 'C');
    }
}
