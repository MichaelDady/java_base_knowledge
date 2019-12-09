package com.makun.classloader.same_class;

import java.lang.reflect.Method;

/**
 * @author Created by makun
 * @Date 2019-12-09
 */
public class Main {

    public static void main(String[] args) throws Exception{

        String classDataRootPath = "/Users/makun/IdeaProjects/java_base_knowledge/src/main/java";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.makun.classloader.same_class.Sample";
        Class<?> class1 = fscl1.loadClass(className);
        Object obj1 =  class1.newInstance();
        Class<?> class2 = fscl2.loadClass(className);
        Object obj2= class2.newInstance();
        Method setMethod = class1.getMethod("setInstance", java.lang.Object.class);
        setMethod.invoke(obj1, obj2);
    }
}
