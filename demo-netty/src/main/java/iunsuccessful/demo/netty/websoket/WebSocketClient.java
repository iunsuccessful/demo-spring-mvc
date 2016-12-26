package iunsuccessful.demo.netty.websoket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import iunsuccessful.demo.netty.PrintPerSecond;

import java.net.URI;


public final class WebSocketClient {

    static final String URL = System.getProperty("url", "ws://123.207.174.231:9501");

    public static void main(String[] args) throws Exception {
        URI uri = new URI(URL);
        EventLoopGroup group = new NioEventLoopGroup();
        try {

//            final WebSocketClientHandler handler =
//                    new WebSocketClientHandler(
//                            WebSocketClientHandshakerFactory.newHandshaker(
//                                    uri, WebSocketVersion.V13, null, false, new DefaultHttpHeaders()));

            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            WebSocketClientHandler handler = new WebSocketClientHandler(WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, false, new DefaultHttpHeaders()));
                            p.addLast(new HttpClientCodec(), new HttpObjectAggregator(8192),  WebSocketClientCompressionHandler.INSTANCE,  handler);
                        }
                    });

//            for (int i = 0; i < 100; i++) {
//                b.connect(uri.getHost(), uri.getPort());
//            }

            PrintPerSecond.start();
            Channel ch = b.connect(uri.getHost(), uri.getPort()).sync().channel();
//            handler.handshakeFuture().sync();
            ch.closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
