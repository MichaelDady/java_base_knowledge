package com.makun.class_loader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author kun.ma on 2019/8/24
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    public MyTest16(String classLoaderName) {
        // 将系统类加载器当做当前类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        // 显示的指定当前类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        System.out.println("load class data block has been called");
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            className = className.replace(".", "/");

            is = new FileInputStream(this.path + className + this.fileExtension);
            baos = new ByteArrayOutputStream();

            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }


    public static void main(String[] args) {
        test4();
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.makun.class_loader.MyTest9");
        Object object = clazz.newInstance();

        System.out.println(object.getClass());
        System.out.println(object);
    }

    /**
     * 自定义的类加载器加载的类可以被卸载
     */
    private static void test4(){
        // jvisualvm
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/makun/Desktop/");
        try {
            Class<?> clazz = loader1.loadClass("com.makun.class_loader.MyTest9");
            Object obj = clazz.newInstance();
            System.out.println(clazz.getClassLoader().getClass().getName());
            System.out.println(obj);
            loader1 = null;
            obj = null;
            clazz = null;
            System.gc();

            Thread.sleep(100000);

            loader1 = new MyTest16("loader1");
            loader1.setPath("/Users/makun/Desktop/");
            clazz = loader1.loadClass("com.makun.class_loader.MyTest9");
            obj = clazz.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test3() {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16(loader1, "loader2");
        MyTest16 loader3 = new MyTest16("loader3");
        loader1.setPath("/Users/makun/Desktop/");
        loader2.setPath("/Users/makun/Desktop/");
        loader3.setPath("/Users/makun/Desktop/");

        try {
            // 如果 MyTest9 目录下已经存在 --> 一种情况
            // 如果 MyTest9 目录下不存在 --> 另一种情况

            Class<?> clazz1 = loader1.loadClass("com.makun.class_loader.MyTest9");
            Class<?> clazz2 = loader2.loadClass("com.makun.class_loader.MyTest9");
            Class<?> clazz3 = loader3.loadClass("com.makun.class_loader.MyTest9");
            System.out.println(clazz1.getClassLoader().hashCode());
            System.out.println(clazz2.getClassLoader().hashCode());
            System.out.println(clazz3.getClassLoader().hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test2() {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16(loader1, "loader2");
        loader1.setPath("/Users/makun/Desktop/");
        loader2.setPath("/Users/makun/Desktop/");

        try {
            // 如果 MyTest9 目录下已经存在 --> 一种情况
            // 如果 MyTest9 目录下不存在 --> 另一种情况

            Class<?> clazz1 = loader1.loadClass("com.makun.class_loader.MyTest9");
            Class<?> clazz2 = loader2.loadClass("com.makun.class_loader.MyTest9");
            System.out.println(clazz1.getClassLoader().hashCode());
            System.out.println(clazz2.getClassLoader().hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1() {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("/Users/makun/Desktop/");
        loader2.setPath("/Users/makun/Desktop/");

        try {
            // 如果 MyTest9 目录下已经存在 --> 一种情况
            // 如果 MyTest9 目录下不存在 --> 另一种情况

            Class<?> clazz1 = loader1.loadClass("com.makun.class_loader.MyTest9");
            Class<?> clazz2 = loader2.loadClass("com.makun.class_loader.MyTest9");
            System.out.println(clazz1.getClassLoader().hashCode());
            System.out.println(clazz2.getClassLoader().hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
