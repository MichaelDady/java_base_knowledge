package com.makun.thread.state;

public class TimeWaitThreadDemo {
    public static void main(String[] args) throws Exception {
        Object obj = new Object();
        Thread thread = new Thread(() -> {
            System.out.println("Enter the block of child thread...");
            synchronized (obj) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Child thread awake...");
            }
        });
        thread.start();
        Thread.sleep(2000);
        System.out.println("The state of child thread : "  + thread.getState());
        synchronized (obj) {
            obj.notifyAll();
        }

        Thread.sleep(2000);
        System.out.println("End of main programme...");

    }
}
