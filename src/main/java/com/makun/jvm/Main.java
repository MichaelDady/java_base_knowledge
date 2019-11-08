package com.makun.jvm;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Human man = new Man();
        Human woman = new Woman();
        main.sayHello(man);
        main.sayHello(woman);
    }

    public void sayHello(Human human) {
        System.out.println("Human say hello");
    }

    public void sayHello(Woman woman) {
        System.out.println("Woman say hello");
    }

    public void sayHello(Man man) {
        System.out.println("Man say hello");
    }


}
