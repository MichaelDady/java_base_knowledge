package com.makun.multi_mode.guarded_suspension;

/**
 * @author Created by makun
 * @Date 2019/8/17
 */
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override public String toString() {
        return "[ Request" + name + "]";
    }
}
