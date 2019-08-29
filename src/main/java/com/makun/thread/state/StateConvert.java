package com.makun.thread.state;

/**
 * @author Created by makun
 * @Date 2018/9/21
 */
public class StateConvert {
    private static Object obj = new Object();
    public static void main(String[] pp) throws Exception {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            System.out.println("Entered Thread a");
            System.out.println("Thread a is Waiting");
            synchronized (obj){
                try {
                    obj.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread a is up.");
        }
    }
}
