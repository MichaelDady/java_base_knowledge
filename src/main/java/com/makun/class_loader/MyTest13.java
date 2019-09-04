package com.makun.class_loader;

/**
 * @author kun.ma on 2019/7/28
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while (null != loader) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
