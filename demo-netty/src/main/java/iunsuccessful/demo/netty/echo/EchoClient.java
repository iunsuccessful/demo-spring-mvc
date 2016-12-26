package iunsuccessful.demo.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author LiQZ on 2016/6/16.
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(0, 2, 0, TimeUnit.SECONDS));
                            ch.pipeline().addLast(new EchoHeathHandler());
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            List<ChannelFuture> cfList = new ArrayList<>();
            for (int i = 0; i < 2; i++ ) {
                cfList.add(b.connect());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                final String input = in.readLine();
                final String line = input != null ? input.trim() : null;
                if (line == null || "quit".equalsIgnoreCase(line)) { // EOF or "quit"
                    cfList.forEach(channelFuture -> channelFuture.channel().close());
                    break;
                } else if (line.isEmpty()) { // skip `enter` or `enter` with spaces.
                    continue;
                }
            }
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("localhost", 8080).start();
    }

}
