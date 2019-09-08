package com.makun.multi_mode.two_phase_termination;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main programme begin...");
        try{
            CountupThread t = new CountupThread();
            t.start();
            Thread.sleep(10000);
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();
            System.out.println("main: join");
            t.join();

        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main programme end...");
    }
}
