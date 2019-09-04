package com.makun.class_loader;

/**
 * @author kun.ma on 2019/8/24
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/makun/Desktop");
        Class<?> clazz = loader1.loadClass("com.makun.class_loader.MySample");
        System.out.println(clazz.hashCode());
        Object obj = clazz.newInstance();
    }
}
