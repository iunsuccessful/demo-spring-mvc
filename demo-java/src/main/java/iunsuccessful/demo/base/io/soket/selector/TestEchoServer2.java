package iunsuccessful.demo.base.io.soket.selector;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author LiQZ on 2016/9/7.
 */
public class TestEchoServer2 {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().setReuseAddress(true);
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(8000));

        Selector selector = Selector.open();

        channel.configureBlocking(false);

        channel.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {

            int readyChannels = selector.select();

            System.out.println(readyChannels);

            if(readyChannels == 0) continue;


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if(key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    System.out.println("isAcceptable");

                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println("isConnectable");

                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    System.out.println("isReadable");

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                    System.out.println("isWritable");
                }

                keyIterator.remove();
            }
        }
    }

}
