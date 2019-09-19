package com.makun.thread.thread_local;

/**
 * @author Created by makun
 * @Date 2019-09-09
 */
public class MyTest1 {
    static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        System.out.println(local.get());
        new Thread () {
            @Override public void run() {
                local.set("sss");
            }
        }.start();
        Thread.sleep(100);
        System.out.println(local.get());

    }
}
