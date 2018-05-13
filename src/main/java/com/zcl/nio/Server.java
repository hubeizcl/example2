package com.zcl.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private int queueNum = 10;
    private int bindPort = 10000;
    private int step = 0;
    private Charset charset = Charset.forName("Utf-8");
    private ByteBuffer buffer = ByteBuffer.allocate(64);

    public static void main(String[] args) {
        try {
            new Server().service();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Server run exception!");
        }
    }

    public Server() {
        try {
            //为ServerSocketChannel监控接收连接就绪事件
            //为SocketChannel监控连接就绪事件、读就绪事件以及写就绪事件
            selector = Selector.open();
            //作用相当于传统通信中的ServerSocket
            //支持阻塞模式和非阻塞模式
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().setReuseAddress(true);
            //非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //serverSocketChannel.socket()会获得一个和当前信道相关联的socket
            serverSocketChannel.socket().bind(new InetSocketAddress(bindPort), queueNum);
            //注册接收连接就绪事件
            //注册事件后会返回一个SelectionKey对象用以跟踪注册事件句柄
            //该SelectionKey将会放入Selector的all-keys集合中，如果相应的事件触发
            //该SelectionKey将会放入Selector的selected-keys集合中
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Server establish error!");
        }
        logger.info("Server start up!");
    }

    public void service() throws IOException {
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.stream().forEach(selectionKey -> {
                try {
                    if (selectionKey.isAcceptable()) {
                        acceptable(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        readable(selectionKey);
                    } else if (selectionKey.isWritable()) {
                        writable(selectionKey);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("event deal exception!");
                }
            });

        }
    }

    private void writable(SelectionKey selectionKey) throws IOException {
        logger.info("write:" + (++step));
        String request = (String) selectionKey.attachment();
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        String answer = "not supported";
        if (request.equals("your name?")) {
            answer = "server";
        }
        logger.info(selectionKey.hashCode() + ":" + answer);

        buffer.clear();
        buffer.put(charset.encode(answer));
        buffer.flip();
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        socketChannel.close();

    }

    private void readable(SelectionKey selectionKey) throws IOException {
        logger.info("read:" + (++step));
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        buffer.clear();
        int num = socketChannel.read(buffer);
        String request = " ";
        if (num > 0) {
            buffer.flip();
            request = charset.decode(buffer).toString();
            socketChannel.register(selector, SelectionKey.OP_WRITE, request);
        } else {
            socketChannel.close();
        }
        logger.info(selectionKey.hashCode() + ":" + request);
    }

    private void acceptable(SelectionKey selectionKey) throws IOException {
        logger.info("accept:" + (++step));
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        logger.info(String.valueOf(selectionKey.hashCode()));
    }


}
