package iunsuccessful.demo.base.io.soket.selector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class TestEchoServer {

    private static final Logger logger = LoggerFactory.getLogger(TestEchoServer.class);

    private Selector selector = null;

    private ServerSocketChannel serverSocketChannel = null;

    private int port = 8000;

    private Charset charset= Charset.forName("UTF-8");

    public TestEchoServer()throws IOException{
        selector = Selector.open();
        serverSocketChannel= ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        logger.info("Server is start[" + new InetSocketAddress(port).getAddress() + ":" + port + "]");
    }

    public void service() throws IOException {

        logger.info("ServerSocketChannel register [" + SelectionKey.OP_ACCEPT + "] to selector");
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
        while (selector.select() > 0) {
//          logger.debug("Select.select() value: " + selector.select());
            Set readyKeys = selector.selectedKeys();
            Iterator it = readyKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = null;
                try {
                    key = (SelectionKey) it.next();
                    it.remove();

                    if (key.isAcceptable()) {
                        logger.info("Selection Key isAcceptable: " + key.isAcceptable());
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = (SocketChannel) ssc.accept();
                        logger.info("Recieved Client Connection:" + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
                        socketChannel.configureBlocking(false);

                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, buffer);
                        logger.info("SocketChannel register [" + SelectionKey.OP_READ  + "] and [" + SelectionKey.OP_WRITE + "] to selector");
                    }

                    if (key.isReadable()) {
                        logger.info("Selection Key isReadable");
                        receive(key);
                    }

                    if (key.isWritable()) {
//                      logger.info("Selection Key isWritable");
                        send(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if (key != null) {
                            key.cancel();
                            key.channel().close();
                        }
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void send(SelectionKey key) throws IOException {
//      logger.info("send");
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        buffer.flip();
        String data = decode(buffer);
        if (data.indexOf("\r\n") == -1){
            return;
        }
        String outputData = data.substring(0, data.indexOf("\n") + 1);
        logger.info("outputData: " + outputData);
        ByteBuffer outputBuffer = encode("echo:" + outputData);
        while (outputBuffer.hasRemaining()){
            socketChannel.write(outputBuffer);
        }

        ByteBuffer temp = encode(outputData);
        buffer.position(temp.limit());
        buffer.compact();

        if (outputData.equals("bye\r\n")) {
            key.cancel();
            socketChannel.close();
            logger.info("Close Client Connection");
        }
    }

    public void receive(SelectionKey key) throws IOException {

        logger.info("receive");

        ByteBuffer buffer = (ByteBuffer) key.attachment();

        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer readBuff = ByteBuffer.allocate(32 * 1024);
        socketChannel.read(readBuff);
        readBuff.flip();

        buffer.limit(buffer.capacity());
        buffer.put(readBuff);
        logger.info("Recieved data: " + decode(buffer));
    }

    public String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str) {
        return charset.encode(str);
    }

    public static void main(String args[]) throws Exception {
        TestEchoServer server = new TestEchoServer();
        server.service();
    }
}
