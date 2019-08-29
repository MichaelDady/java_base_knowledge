package com.makun.classloader.mine;

/**
 * @author kun.ma on 2019/7/28
 */
public class MyTest11 {
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();
    }
}


class Parent3 {
    static int a = 2;

    static {
        System.out.println("parent3 static block");
    }

    static void doSomething () {
        System.out.println("do something");
    }
}


class Child3 extends Parent3 {
    static int b = 3;

    static {
        System.out.println("child3 static block");
    }


}
