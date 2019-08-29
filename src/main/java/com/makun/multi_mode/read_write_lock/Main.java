package com.makun.multi_mode.read_write_lock;

/**
 * @author Created by makun
 * @Date 2019/8/18
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();

        new WriterThread(data, "djfiodsjfiowejrioewjriew").start();
        new WriterThread(data, "DJFIODSJFIOWEJRIOEWJRIEW").start();

    }
}
