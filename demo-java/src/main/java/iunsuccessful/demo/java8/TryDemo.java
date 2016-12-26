package iunsuccessful.demo.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Java 7 的一些特性
 * Created by Anonymous on 2016-03-19.
 */
public class TryDemo {

    /** 可以添加下划线 */
    int thousand = 1_000;
    int million  = 1_000_000;

    /**
     * 用 try () {} 会自动关闭资源，取代：
     * <pre>
     *     BufferedReader br = new BufferedReader(new FileReader("path");
     *     try {
     *         br.readLine();
     *     } catch(IOException e) {
     *         // ...
     *     } finally {
     *        if br != null br.close();
     *     }
     * </pre>
     * Note: 因为实现了 AutoCloseable，自己也可以实现
     * @since 1.7
     * @throws IOException
     */
    private void readFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
            br.readLine();
        }
    }

    /**
     * 多重异常捕获
     * @since 1.7
     * @param i
     */
    private void mulitException(int i) {
        try {
            switch (i) {
                case 1: throw new IOException();
                case 2: throw new SQLException();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Output: home\document
     */
    private void paths() {
        Path path = Paths.get("home", "document");
        System.out.println(path);
    }

}
