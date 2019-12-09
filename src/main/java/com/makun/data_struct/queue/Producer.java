package com.makun.data_struct.queue;

/**
 * @author Created by makun
 * @Date 2019-12-06
 */

public class Producer {
    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void produce(Long data) throws InterruptedException {
        while (!queue.add(data)) {
            Thread.sleep(100);
        }
    }
}
