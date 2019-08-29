package com.makun.multi_mode.balking;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class ChangeThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangeThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override public void run() {
        try{
            for(int i = 0;true; i++){
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        super.run();
    }
}
