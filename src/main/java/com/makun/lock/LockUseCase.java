package com.makun.lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * @author Created by makun
 * @Date 2019-09-10
 */
public class LockUseCase {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
