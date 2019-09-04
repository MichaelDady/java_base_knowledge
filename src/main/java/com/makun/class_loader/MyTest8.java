package com.makun.class_loader;

/**
 * @author kun.ma on 2019/7/28
 */

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block...");
    }
}


public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
