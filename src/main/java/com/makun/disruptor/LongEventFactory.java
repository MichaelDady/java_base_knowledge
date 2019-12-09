package com.makun.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author Created by makun
 * @Date 2019-12-06
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
