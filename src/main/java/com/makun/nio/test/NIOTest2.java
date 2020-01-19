package com.makun.nio.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest2 {
    public static void main(String[] args) throws Exception {

        //传统io读取数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt"), "UTF-8"));

        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

        System.out.println("----------");

        //nio读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        FileChannel fileChannel = new FileInputStream("def.txt").getChannel();

        //将Channel中的数据读取到byteBuffer中
        fileChannel.read(byteBuffer);

        //改变bytebuffer状态，由可写变成可读
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
    }
}
