package com.makun.classloader;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class Dog {
    public Dog() {
        System.out.println("Dog Constructor has been called...");
        System.out.println("Dog Class is loaded by " + this.getClass().getClassLoader());
        System.out.println("Dog call Sample class:" + Sample.class);

        System.out.println();
    }
}
