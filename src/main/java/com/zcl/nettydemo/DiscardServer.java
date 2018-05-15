package com.zcl.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author :zhangchenglong
 * @Date :2018年 05月13日17时30分
 * @Description :
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() {
        /**
         * NioEventLoopGroup是一个处理I / O操作的多线程事件循环。
         * Netty为不同类型的传输提供了各种EventLoopGroup实现。
         * 在这个例子中，我们正在实现一个服务器端应用程序，因此将使用两个NioEventLoopGroup。
         */
        //第一个，通常称为“老板”，接受传入的连接。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 第二个，通常称为“工人”，一旦老板接受连接并将接受的连接注册给工作人员，
        // 就处理接受的连接的流量。使用多少线程以及它们如何映射到创建的通道取决于EventLoopGroup实现，
        // 甚至可以通过构造函数进行配置。
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // ServerBootstrap是一个帮助类，用于设置服务器。您可以直接使用Channel设置服务器。
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                //我们指定使用NioServerSocketChannel类来实例化一个新的Channel来接受传入的连接。
                //可以这么理解，每个客户端连接我们服务端，我们都会为他们创建一个channel，那么这个channel对于面向对象的我们来说就是一个类，
                // 我们同意对于我们接受到的连接都初始化为：NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                //ChannelInitializer是一个特殊的处理程序，旨在帮助用户配置新的Channel。
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new DiscardServerHandler());
                    }
                })
                //option（）用于接受传入连接的NioServerSocketChannel。
                .option(ChannelOption.SO_BACKLOG, 128)
                //childOption（）用于在这种情况下由父级ServerChannel接受的通道，即NioServerSocketChannel。
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture future = bootstrap.bind(port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();
    }
}
