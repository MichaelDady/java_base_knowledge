package com.makun.thread;

/**
 * @author Created by makun
 * @Date 2019-11-04
 */
public class VolatileDemo {
    private static boolean flag = true;

    private static Object obj = new Object();

    public static void main(String[] args) throws Exception {
        long time0 = System.currentTimeMillis();

        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                    System.out.println("Child thread end...");
                }
                super.run();
            }
        }.start();

        synchronized (obj) {
            while (flag) {
                Thread.sleep(100);
            }
        }


        System.out.println(System.currentTimeMillis() - time0);
    }

}
