package com.makun.thread.state;

/**
 * @author Created by makun
 * @Date 2019-09-09
 */
public class MyTest1 {
    public static void main(String[] args) throws InterruptedException {
        TaskA t = new TaskA();
        t.setThread(new Thread(){
            @Override public void run() {
                try {
                    System.out.println("join Thread begin...");
                    Thread.sleep(3000);
                    System.out.println("join Thread end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.sleep(100);
        System.out.println("The state of Thread A : " + t.getState());
    }

    static class TaskA extends Thread{
        public void setThread(Thread thread) {
            this.thread = thread;
        }

        Thread thread ;

        @Override public void run() {
            try {
                System.out.println("join begin...");
                thread.start();
                thread.join();
                System.out.println("join end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
