package com.makun.concurrent;

import java.util.concurrent.atomic.*;


public class AtomicCounter {
    private AtomicInteger integer = new AtomicInteger();

    public AtomicInteger getInteger() {
        return integer;
    }

    public void setInteger(AtomicInteger integer) {
        this.integer = integer;
    }

    public void increment() {
        integer.incrementAndGet();
    }

    public void decrement() {
        integer.decrementAndGet();
    }
}
