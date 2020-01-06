package com.makun.lock;

public class SynchronizedTest {
    private static Lock lock = new Lock();
    private static int counter = 0;

    public static void foo() {
        synchronized (lock) {
            counter++;
        }
    }

    public static void main(String[] args) {
        // lock.hashCode(); // Step 2
        // System.identityHashCode(lock); // Step 4
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            foo();
        }
        System.out.println("cost : " + (System.currentTimeMillis() - startTime));
    }


    static class Lock {
        // @Override public int hashCode() { return 0; } // Step 3
    }
}
