package com.makun.nio.test;

import java.nio.IntBuffer;
import java.util.Random;

public class NIOTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(100);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int randomNumber = new Random().nextInt(100);
            intBuffer.put(randomNumber);
        }
        //状态反转，使buffer成为可读状态
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
