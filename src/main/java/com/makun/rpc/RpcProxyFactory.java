package com.makun.rpc;

import java.lang.reflect.Proxy;

/**
 * @author Created by makun
 * @Date 2019-12-10
 */
public class RpcProxyFactory {

    public static <T> T getService(Class<T> interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass },
                new RpcHandler());
    }

}
