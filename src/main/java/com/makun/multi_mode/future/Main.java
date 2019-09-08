package com.makun.multi_mode.future;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main programme begin...");
        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        System.out.println("main other Job begin...");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main programme end...");
    }
}
