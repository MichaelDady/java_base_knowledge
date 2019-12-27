package com.makun.rpc;

/**
 * @author Created by makun
 * @Date 2019-12-10
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
