package com.makun.multi_mode.produce_consumer;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class EaterThread extends Thread {

    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, Long seed) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    @Override public void run() {
        try {
            while(true){
                String cake = table.getCake();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
