package com.makun.multi_mode.balking;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override public void run() {
        try {
            while (true) {
                data.save();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.run();
    }
}
