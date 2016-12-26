package iunsuccessful.demo.netty.soop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A simple HTTP client that prints out the content of the HTTP response to
 */
public final class HttpSnoopClient {

//    http://2718.liveplay.myqcloud.com/2718_35635b02594811e6a2cba4dcbef5e35a.m3u8

//    static final String URL = System.getProperty("url", "http://2718.liveplay.myqcloud.com/2718_35635b02594811e6a2cba4dcbef5e35a.m3u8");
    static final String URL = System.getProperty("url", "http://phonehuodongtx.imgo.tv:80/nn_live/nn_x64/aWQ9c3VwZXJ6anM1NDAmY2RuZXhfaWQ9dHhfcGhvbmVfbGl2ZQ,,/superzjs540.m3u8");

//    public static Pattern pattern = Pattern.compile("(2718_.*?\\.ts.*?key=)");
    public static Pattern pattern = Pattern.compile("(nn_live.*?\\.ts)");


    public static void main(String[] args) throws Exception {

        URI uri = getURI();

        assert uri != null;

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(uri.getHost(), uri.getPort())
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new HttpClientCodec());
                            p.addLast(new HttpContentDecompressor());
                            p.addLast(new HttpObjectAggregator(64 * 1024));
                            p.addLast(new HttpSnoopClientHandler());
                        }
                    });

            // Make the connection attempt.
            for (int i = 0; i < 1; i++ ) {
                b.connect();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                final String input = in.readLine();
                final String line = input != null ? input.trim() : null;
                if (line == null || "quit".equalsIgnoreCase(line)) { // EOF or "quit"
                    break;
                }
            }

        } finally {
            group.shutdownGracefully();
        }
    }

    public static URI getURI() {
        try {
            return new URI(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}