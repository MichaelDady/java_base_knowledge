package com.makun.classloader;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class Sample {
    public Sample() {
        System.out.println("Sample Constructor has been called...");
        System.out.println("Sample Class is loaded by " + this.getClass().getClassLoader());
        System.out.println();
        new Dog();
    }
}
