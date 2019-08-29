package com.makun.multi_mode.produce_consumer;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int n) {
        this.buffer = new String[n];
    }

    public synchronized void put(String cake) throws Exception{
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while(count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String getCake() throws Exception{
        while(count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count --;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

}
