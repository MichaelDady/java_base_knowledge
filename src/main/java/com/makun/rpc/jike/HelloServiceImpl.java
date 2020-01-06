package com.makun.rpc.jike;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        String ret = "Hello, " + name;
        return ret;
    }
}