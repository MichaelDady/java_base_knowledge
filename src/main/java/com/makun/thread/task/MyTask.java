package com.makun.thread.task;

import java.sql.Time;

/**
 * @author Created by makun
 * @Date 2019/1/21
 */
public class MyTask implements Runnable{
    Time startTime;
    Long requireId;

    public MyTask(Time startTime, Long requireId) {
        this.startTime = startTime;
        this.requireId = requireId;
    }

    @Override
    public void run() {

    }
}
