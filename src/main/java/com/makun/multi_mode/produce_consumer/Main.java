package com.makun.multi_mode.produce_consumer;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table,85435L).start();
        new MakerThread("MakerThread-2", table,2323453L).start();
        new MakerThread("MakerThread-3", table,843573L).start();
        new EaterThread("EaterThread-1", table,85435L).start();
        new EaterThread("EaterThread-1", table,75766L).start();
        new EaterThread("EaterThread-1", table,99888L).start();
    }
}
