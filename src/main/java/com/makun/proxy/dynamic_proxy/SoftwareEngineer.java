package com.makun.proxy.dynamic_proxy;

/**
 * @author Created by makun
 * @Date 2019-09-19
 */
public class SoftwareEngineer implements Person {
    public SoftwareEngineer() {}

    public SoftwareEngineer(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void goWorking(String name, String dst) {
        System.out.println("name =" + name + " ， 去 " + dst + " 工作");
    }
}
