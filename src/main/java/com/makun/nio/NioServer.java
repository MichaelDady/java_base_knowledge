package com.makun.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功...");

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            // 可用 Channel集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isReadable()) {
                    readHandler(serverSocketChannel, selector);
                }
                if (key.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }

            }
        }
    }

    private static void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws Exception {
        SocketChannel socketChannel = serverSocketChannel.accept();

        socketChannel.configureBlocking(false);

        socketChannel.register(selector, SelectionKey.OP_READ);


    }

    private static void readHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws Exception {

    }


}
