package com.makun.classloader;

/**
 * @author Created by makun
 * @Date 2019/8/29
 */
public class GetProperties {
    public static void main(String[] args) throws Exception {
        // 启动类加载路径 sun.boot.class.path
        // 扩展类加载路径 java.ext.dirs
        // 应用类加载路径 java.class.path

        String[] pathArray = System.getProperty("sun.boot.class.path").split(":");
        for(String path : pathArray) {
            System.out.println(path);
        }
    }
}
