package iunsuccessful.demo.base.io.soket.selector.provider;

import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.ServerSocketChannel;
import java.net.InetSocketAddress;
import java.io.IOException;

public class SelectorProviderExample {

    public static void main (String [] args) throws IOException {

        ServerSocketChannel serverChannel = SelectorProvider.provider().openServerSocketChannel();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 3888);
        serverChannel.bind(hostAddress);

        System.out.println("Server socket channel bound to port: " + hostAddress.getPort());
        System.out.println("Waiting for client to connect... ");

        SocketChannel socketChannel = serverChannel.accept(); // the socket channel for the new connection

        // Process further; send or receive messages to-fro client here ...

        socketChannel.close();
        serverChannel.close();
    }
}
