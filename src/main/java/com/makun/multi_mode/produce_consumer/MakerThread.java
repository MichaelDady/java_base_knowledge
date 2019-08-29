package com.makun.multi_mode.produce_consumer;

import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, Long seed) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    @Override public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake No." + nextId() + " by " + getName() + "]";
                table.put(cake);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
