package iunsuccessful.demo.base.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by LiQZ on 2017/11/15.
 */
public class FilesWriterDemo {

    public static void main(String[] args) throws IOException {
        String content = "Hello World !!\nbbb";
        Files.write(Paths.get("D:/a/output.txt"), content.getBytes());
    }

}
