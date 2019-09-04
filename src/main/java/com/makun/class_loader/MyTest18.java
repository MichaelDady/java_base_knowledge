package com.makun.class_loader;

/**
 * @author kun.ma on 2019/8/28
 */
public class MyTest18 {
    public static void main(String[] args) {
        // 系统类加载器的加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 扩展类加载器的加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        // 应用类加载器的加载路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
