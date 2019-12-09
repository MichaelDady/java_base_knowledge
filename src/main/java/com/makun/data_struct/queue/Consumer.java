package com.makun.data_struct.queue;

/**
 * @author Created by makun
 * @Date 2019-12-06
 */
public class Consumer {
    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public void comsume() throws InterruptedException {
        while (true) {
            Long data = queue.poll();
            if (data == null) {
                Thread.sleep(100);
            } else {
                // TODO:...消费数据的业务逻辑...
            }
        }
    }
}
