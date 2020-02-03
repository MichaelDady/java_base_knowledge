package com.makun.zookeeper.distributed_lock;

import java.util.concurrent.locks.Lock;

public class Test {
    //100张票
    private Integer n = 100;
//    private Lock lock = new ReentrantLock();

    public void printInfo() {
        System.out.println(Thread.currentThread().getName() +
                "正在运行,剩余余票:" + --n);
    }

    public class TicketThread implements Runnable {
        public void run() {
            Lock lock = new DistributedLock("192.168.150.111:2181,192.168.150.112:2181,192.168.150.113:2181", "zk");
            lock.lock();
            try {
                if (n > 0) {
                    printInfo();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void ticketStart() {
        TicketThread thread = new TicketThread();
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(thread, "mem" + i);
            t.start();
        }
    }

    public static void main(String[] args) {
        new Test().ticketStart();
    }
}
