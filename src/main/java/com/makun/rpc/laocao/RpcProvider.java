package com.makun.rpc.laocao;

/**
 * @author Created by makun
 * @Date 2019-12-10
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcExport.export(service);
    }
}
