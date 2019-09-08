package com.makun.multi_mode.two_phase_termination;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class CountupThread extends Thread {
    private long counter = 0;
    private volatile boolean shutdownRequested = false;

    public void shutdownRequest() {
        this.shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doShutdown();
        }
    }

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }

    private void doWork() throws Exception {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

}
