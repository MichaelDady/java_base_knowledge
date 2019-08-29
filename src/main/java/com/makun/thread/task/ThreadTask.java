package com.makun.thread.task;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Created by makun
 * @Date 2019/1/21
 */
public class ThreadTask {
    public static void main(String[] pp) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("First Task");
                System.out.println(format.format(System.currentTimeMillis()));
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Second Task");
                System.out.println(format.format(System.currentTimeMillis()));
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, format.parse("2019-01-21 16:17:33"));
        timer.schedule(task2, format.parse("2019-01-21 16:17:33"));
    }
}
