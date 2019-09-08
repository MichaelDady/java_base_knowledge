package com.makun.multi_mode.future;

/**
 * @author Created by makun
 * @Date 2019-09-07
 */
public class Host {
    public Data request(final int count , final char c ){
        System.out.println(" request(" + count + ", " + c + ") begin...");
        final FutureData futureData = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(count , c);
            futureData.setRealData(realData);
        }).start();

        return futureData;

    }
}
