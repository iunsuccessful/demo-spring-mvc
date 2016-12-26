package iunsuccessful.demo.base.nio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * 文件异步读取
 * @author LiQZ on 2016/9/9.
 */
public class AsynchronousFileChannelDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("demo-java\\src\\main\\resources\\data\\file.txt");

//        System.out.println(path.toAbsolutePath());

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
//        read1(fileChannel);
        read2(fileChannel);


    }

    /**
     * 低效的读取方法  while(!operation.isDone());
     */
    private static void read1(AsynchronousFileChannel fileChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        Future<Integer> operation = fileChannel.read(buffer, position);

        while(!operation.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }

    private static void read2(AsynchronousFileChannel fileChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);
                System.out.println("result = " + attachment);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("failed");
            }
        });
    }

}
