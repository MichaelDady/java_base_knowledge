package com.makun.class_loader;

import sun.misc.Launcher;

/**
 * @author kun.ma on 2019/8/31
 * 在运行期，一个java类由该类的完全限定名和用于加载该类的定义类加载器共同决定的，
 * 如果同样名字的类是由两个不同的加载器加载，那么这些类就是不同的，即使.class文
 * 件的字节码完全一样也如此
 *
 * 在Oracle 的 HotSpot中，系统属性如果出错了，那么运行会出错
 *
 * 数组是由 jvm 虚拟机加载的
 *
 * 纯 java 写的类加载器是由谁加载的？
 * 是由启动类加载器来加载的
 *
 * 内建于 jvm 中的启动类加载器会加载 java.lang.ClassLoader 以及其它的 java 平台类，当 jvm 启动的时候
 * 一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，这块特殊的机器码就叫做启动类加载器，启动类
 * 加载器并不是 java 类，其它类加载器都是 java 类。
 * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程
 *
 * 所有类加载器（除了启动类加载器）都被实现为java类，不过总归有一个组件来加载第一个java类加载器，从而让
 * 整个加载过程能够顺利进行下去，而加载第一个纯java类加载器就是启动类加载器的职责。
 *
 * 启动类加载器还会负责加载供jre正常运行所需要的基本组件，这包括java.util和java.lang包中的类等
 *
 *
 */
public class MyTest23 {
    /**
     * sun.boot.class.path
     * java.ext.dirs
     * java.class.path
     */
    public static void main(String[] args) {
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println(Launcher.class.getClassLoader());

        // 系统默认的系统类加载器
        // java -Djava.system.class.loader=com.makun.class_loader.MyTest16 com.makun.class_loader.MyTest23
        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
