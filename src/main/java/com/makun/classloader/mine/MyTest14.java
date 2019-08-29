package com.makun.classloader.mine;

import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/**
 * @author kun.ma on 2019/7/28
 */
public class MyTest14 {
    /**
     * 类加载器是用来加载类的，不是加载对象的
     * 获取ClassLoader的路径 ：
     * 1. clazz.getClassLoader() ：获取当前类的ClassLoader
     * 2. 获取当前线程上下文的ClassLoader： Thread.currentThread().getContextLoader()
     * 3. 获取系统的ClassLoader： ClassLoader.getSystemClassLoader()
     * 4. 获取调用者的ClassLoader： DriverManager.getCallerClassLoader()
     */
    public static void main(String[] args) throws Exception {
        // 获取上下文类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        // 定义一个资源，就是包名，但 . 需要转换为 /
        String resourceName = "com/makun/class_loader/MyTest13.class";
        // 获取这个资源到底在哪里
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        // 根据类获取类加载器
        Class<?> clazz = List.class;
        System.out.println(clazz.getClassLoader());

        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());

        System.out.println(String.class.getClassLoader());
    }

    class Student {

    }
}
