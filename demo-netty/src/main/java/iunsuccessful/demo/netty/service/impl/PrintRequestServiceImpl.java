package iunsuccessful.demo.netty.service.impl;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 使用 Netty 监听端口，打印请求
 * Created by LiQZ on 2017/3/26.
 */
public class PrintRequestServiceImpl {

    // 所使用的线程
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("netty-server-pool-%d").setDaemon(true).build();
    ExecutorService parentExecutor = Executors.newSingleThreadExecutor(threadFactory);
    final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(parentExecutor);

    private int port;

    public PrintRequestServiceImpl(int port) {
        this.port = port;
    }

    public void init() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void start() throws Exception {
        final PrintRequestServiceHandler serverHandler = new PrintRequestServiceHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // NIO服务的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            b.group(group) // set parent group and child group
                    .channel(NioServerSocketChannel.class) // create channel factory
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            b.bind().sync().channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
