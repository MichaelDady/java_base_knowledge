package com.makun.classloader.same_class;

/**
 * @author Created by makun
 * @Date 2019-12-09
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while(loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }

    }
}
