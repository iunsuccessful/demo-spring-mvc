package iunsuccessful.demo.base.io;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author LiQZ on 2016/9/5.
 */
public class SelectorProviderDemo {

    private static final SelectorProvider provider = SelectorProvider.provider();


    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    static class HttpServer {

        public void await() {
            try {
                doAwait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doAwait() throws IOException {
            ServerSocketChannel channel = provider.openServerSocketChannel();
            channel.socket().setReuseAddress(true);
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(8080));
        }

    }


}
