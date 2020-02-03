package com.makun.javabasic.src.com.interview.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
//        Class rc = Class.forName("com.makun.javabasic.src.com.interview.javabasic.reflect.Robot");
//        Robot r = (Robot) rc.newInstance();
//        System.out.println("Class name is " + rc.getName());
//        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
//        getHello.setAccessible(true);
//        Object str = getHello.invoke(r, "Bob");
//        System.out.println("getHello result is " + str);
//        Method sayHi = rc.getMethod("sayHi", String.class);
//        sayHi.invoke(r, "Welcome");
//        Field name = rc.getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(r, "Alice");
//        sayHi.invoke(r, "Welcome");
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));
        String[] arr = new String[]{"10", "0", "1"};

        System.out.println(getResult(1, 1, arr, arr.length - 1));
    }


    static int getResult(int m, int n, String[] arr, int step) {
        if (step < 0 || step >= arr.length) {
            return 0;
        }

        // m : 0     n : 1
        String s = arr[step];

        int zeroNum = 0;
        int oneNum = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('0' == s.charAt(i)) {
                zeroNum++;
            }
            if ('1' == s.charAt(i)) {
                oneNum++;
            }
        }
        if (step == 0) {
            return m >= zeroNum && n >= oneNum ? 1 : 0;
        }

        if (m >= zeroNum && n >= oneNum) {
            // 此时step的字符串可拼出
            return Math.max(1 + getResult(m - zeroNum, n - oneNum, arr, step - 1), getResult(m, n, arr, step - 1));
        } else {
            return getResult(m, n, arr, step - 1);
        }
    }


}
