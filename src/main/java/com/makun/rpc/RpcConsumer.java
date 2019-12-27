package com.makun.rpc;

/**
 * @author Created by makun
 * @Date 2019-12-10
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService proxy = RpcProxyFactory.getService(HelloService.class);
        String result = proxy.sayHello("world");
        System.out.println(result);
    }
}
