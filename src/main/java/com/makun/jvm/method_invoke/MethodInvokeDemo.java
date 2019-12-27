package com.makun.jvm.method_invoke;

public class MethodInvokeDemo {
    public static void main(String[] args) {
        String str = "dfjskl-";
        if (str.endsWith("-")){
            System.out.println(str.substring(0, str.length()-1));
        }


//        Parent p  = new Child();
//        p.sayHello();
//        p.sayGoodBye();

    }


    static class Parent {
        public static void sayHello() {
            System.out.println("Parent say hello");
        }

        public void sayGoodBye() {
            System.out.println("Parent say goodBye");

        }


    }

    static class Child extends Parent {
        public static void sayHello() {
            System.out.println("Child say hello");
        }

        public void sayGoodBye() {
            System.out.println("Child say goodBye");

        }

    }
}

