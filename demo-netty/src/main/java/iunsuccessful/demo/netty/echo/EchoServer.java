package iunsuccessful.demo.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Discards any incoming data.
 */
public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
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
            ChannelFuture f = b.bind().sync();
            /** <code>NIOServerSocketChannel</code> */
//            Channel channel = f.channel();
            // AbstractChannel$CloseFuture
//            ChannelFuture channelFuture = channel.closeFuture();
            synchronized (this) {
                wait();
            }
//            channelFuture.sync();
//            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]): 8080;
        new EchoServer(port).start();
    }
    
}
