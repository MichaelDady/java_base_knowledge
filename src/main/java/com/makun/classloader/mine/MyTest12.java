package com.makun.classloader.mine;

/**
 * @author kun.ma on 2019/7/28
 */
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.makun.class_loader.CL");
        System.out.println(clazz);

        System.out.println("-----------------");
        clazz = Class.forName("com.makun.class_loader.CL");

        System.out.println(clazz);
    }
}


class CL {
    static {
        System.out.println("Class CL");
    }
}
