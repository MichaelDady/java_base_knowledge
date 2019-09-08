package com.makun.multi_mode.worker_thread;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Channel {
    private static final int MAX_REQUEST = 10;
    private final Request[] requestQueue;
    private int head;
    private int tail;
    private int count;
    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker - " + i, this);
        }
    }

    public void startWorkers() {
        for (WorkerThread workerThread : threadPool) {
            workerThread.start();
        }
    }

    public synchronized void putRequest(Request request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }


}
