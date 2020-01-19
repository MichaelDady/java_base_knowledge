package com.makun.thread;

public class PrintExchange {
    public static void main(String[] args) throws Exception {
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] number = new int[26];
        for (int i = 0; i < 26; i++) {
            number[i] = i + 1;
        }

        Object obj = new Object();

        new Thread(() -> {
            for (int i = 0; i < s.length(); i++) {
                synchronized (obj) {

                    System.out.print(s.charAt(i));
                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
        Thread.sleep(300);

        new Thread(() -> {

            for (int i = 0; i < s.length(); i++) {
                synchronized (obj) {

                    System.out.print(number[i]);
                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
