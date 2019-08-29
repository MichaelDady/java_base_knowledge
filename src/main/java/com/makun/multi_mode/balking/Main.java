package com.makun.multi_mode.balking;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangeThread("ChangeThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
