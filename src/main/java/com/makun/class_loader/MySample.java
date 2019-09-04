package com.makun.class_loader;

/**
 * @author kun.ma on 2019/8/27
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by " + this.getClass().getClassLoader());
        // 加载了 MySample 的类加载器会尝试加载 MyCat 类
        new MyCat();

        System.out.println("From MySample: " + MyCat.class);
    }
}
