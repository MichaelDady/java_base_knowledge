package com.makun.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Created by makun
 * @Date 2019-09-10
 */
public class Mutex implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }


    @Override public void lock() {

    }

    @Override public void lockInterruptibly() throws InterruptedException {

    }

    @Override public boolean tryLock() {
        return false;
    }

    @Override public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override public void unlock() {

    }

    @Override public Condition newCondition() {
        return null;
    }
}
