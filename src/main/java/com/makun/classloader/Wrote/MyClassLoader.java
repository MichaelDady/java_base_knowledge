package com.makun.classloader.Wrote;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Created by makun
 * @Date 2019/8/27
 */
public class MyClassLoader extends ClassLoader {
    private static final String END_FIX = ".class";

    private String classLoaderName;

    private String path;

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    //    public static void main(String[] args) throws Exception {
    //        MyClassLoader loader = new MyClassLoader("loader1");
    //        loader.setPath("/Users/makun/Desktop/");
    //        Class<?> clazz = loader.loadClass("com.makun.classloader.Employee");
    //        System.out.println(clazz.getClassLoader());
    //    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = loadData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadData(String className) {
        System.out.println("load data block has been called");
        byte[] result = null;
        String classPath = path + className.replace(".", File.separator) + END_FIX;
        try (InputStream is = new FileInputStream(classPath); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int c;
            while ((c = is.read()) != -1) {
                baos.write(c);
            }
            result = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
