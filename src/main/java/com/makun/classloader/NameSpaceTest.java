package com.makun.classloader;

import java.lang.reflect.Method;

/**
 * @author Created by makun
 * @Date 2019/8/28
 */
public class NameSpaceTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");
        loader1.setPath("/Users/makun/Desktop/");
        loader2.setPath("/Users/makun/Desktop/");
        Class<?> clazz1 = loader1.loadClass("com.makun.classloader.Bird");
        Class<?> clazz2 = loader2.loadClass("com.makun.classloader.Bird");
        System.out.println(clazz1 == clazz2);

        Object object1= clazz1.newInstance();
        Object object2= clazz2.newInstance();
        System.out.println(object1.getClass().getClassLoader());
        System.out.println(object2.getClass().getClassLoader());

        Method method = clazz1.getMethod("setBird", Object.class);
        method.invoke(object1, object2);
    }
}
