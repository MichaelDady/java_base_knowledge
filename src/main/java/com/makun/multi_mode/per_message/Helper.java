package com.makun.multi_mode.per_message;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Helper {
    public void handle(int count, char c) {
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.println(c);
        }
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
