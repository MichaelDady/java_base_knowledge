package com.makun.concurrent;

public class AtomicConsumer extends Thread {

    private AtomicCounter atomicCounter;

    public AtomicConsumer(AtomicCounter atomicCounter) {
        this.atomicCounter = atomicCounter;
    }

    @Override
    public void run() {
        for (int j = 0; j < AtomicTest.LOOP; j++) {
            System.out.println("consumer : " + atomicCounter.getInteger());
            atomicCounter.decrement();
        }
    }
}