package com.makun.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author Created by makun
 * @Date 2019-12-06
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Event: " + event);
    }
}
