package com.makun.class_loader;

import java.lang.reflect.Method;

/**
 * @author kun.ma on 2019/8/29
 *
 * 类加载器的双亲委托模型的好处：
 * 1. 可以确保java核心库的类型案例：所有的java应用都至少会引用 java.lang.Object 类，也就是说在运行期，
 * java.lang.Object 这个类会被加载到java虚拟机中，如果这个加载过程是由java自己的类加载器完成的，那么很
 * 可能就会在jvm存在多个版本的java.lang.Object类，而且这些类之间还是不兼容相互不可见的。这一点正是命名空
 * 间在发挥着作用。
 * 2.
 *
 *
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("/Users/makun/Desktop/");
        loader2.setPath("/Users/makun/Desktop/");

        Class<?> clazz1 = loader1.loadClass("com.makun.class_loader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.makun.class_loader.MyPerson");

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(object1, object2);

    }
}
