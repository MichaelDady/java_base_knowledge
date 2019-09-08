package com.makun.multi_mode.future;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }


    @Override public String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }
}
