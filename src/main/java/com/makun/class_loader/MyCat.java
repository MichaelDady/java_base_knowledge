package com.makun.class_loader;

/**
 * @author kun.ma on 2019/8/27
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by" + this.getClass().getClassLoader());


        System.out.println("from MyCat: " + MySample.class);
    }
}
