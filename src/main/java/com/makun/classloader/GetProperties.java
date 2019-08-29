package com.makun.classloader;

/**
 * @author Created by makun
 * @Date 2019/8/29
 */
public class GetProperties {
    public static void main(String[] args) {

        // 启动类加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 扩展类加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        // 应用类加载路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
