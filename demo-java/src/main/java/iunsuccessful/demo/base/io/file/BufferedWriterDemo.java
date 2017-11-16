package iunsuccessful.demo.base.io.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by LiQZ on 2017/11/15.
 */
public class BufferedWriterDemo {

    public static void main(String[] args) throws IOException {

        //Get the file reference
        Path path = Paths.get("D:/a/output.txt");

        //Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND))
        {
            writer.write("aaa:bbb\n");
            writer.write("bbb:ccc");
        }



    }

}
