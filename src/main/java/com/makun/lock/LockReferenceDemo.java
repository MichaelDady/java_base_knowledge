package com.makun.lock;

import lombok.SneakyThrows;

public class LockReferenceDemo {
    public static void main(String[] args) throws Exception {
        Bag bag = new Bag();
        Employee employee = new Employee();
        employee.bag = bag;

        new Thread(() -> {
            synchronized (employee) {
                try {
                    System.out.println("employee block printed...");
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(30);

        new Thread(() -> {
            synchronized (bag) {
                System.out.println("bag block printed...");
            }
        }).start();
    }

    static class Employee {
        Bag bag;
    }

    static class Bag {

    }


}
