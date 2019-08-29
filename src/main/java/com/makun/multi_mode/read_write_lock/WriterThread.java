package com.makun.multi_mode.read_write_lock;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/8/18
 */
public class WriterThread extends Thread {
    private static final Random RANDOM = new Random();
    private final Data data;
    private final String filler;
    private int index = 0;

    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(RANDOM.nextInt(3000));
            }
        } catch (Exception ignored) {

        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
