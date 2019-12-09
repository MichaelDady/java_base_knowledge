package com.makun.data_struct.queue;

/**
 * @author Created by makun
 * @Date 2019-12-06
 */
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println(queue.add(1L));
        System.out.println(queue.add(1L));
        System.out.println(queue.add(1L));
        System.out.println(queue.add(1L));
        System.out.println(queue.add(1L));
        System.out.println(queue);
    }
}
