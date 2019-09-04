package com.makun.class_loader;

/**
 * @author kun.ma on 2019/8/30
 */
public class MyTest22 {
    // java -Djava.ext.dirs=./ com.makun.class_loader.MyTest22
    static {
        System.out.println(
                "MyTest22 initializer"
        );
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
    }
}
