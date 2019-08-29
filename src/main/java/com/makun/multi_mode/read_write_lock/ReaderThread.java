package com.makun.multi_mode.read_write_lock;

/**
 * @author Created by makun
 * @Date 2019/8/18
 */
public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }



    @Override public void run() {
        try {

            while (true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (Exception e) {

        }

    }
}
