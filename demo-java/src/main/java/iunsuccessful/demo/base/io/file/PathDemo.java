package iunsuccessful.demo.base.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Files.list 当前目录下的文件
 * Files.walk 包括子目录
 * 关于 PathMatcher 前缀，参考这里：
 * http://java.boot.by/ocpjp7-upgrade/ch06s05.html
 * Created by LiQZ on 2017/12/22.
 */
public class PathDemo {

    public static void main(String[] args) {

        Path start = new File("demo-java").toPath();

        // 查看绝对路径
        System.out.println(start.toAbsolutePath());

        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        try (Stream<Path> paths = Files.walk(start)) {
            paths
                .filter(Files::isRegularFile) // 是文件的(不是符号链接、目录、磁盘、socket等)
                .filter(pathMatcher::matches) // 路径配匹
                .flatMap(path -> {
                    Stream<String> lines;
                    try {
                        lines = Files.readAllLines(path).stream();
                    } catch (IOException e) {
                        lines = Stream.of("");
                    }
                    return lines;
                })
                .filter(line -> !line.isEmpty())
                .filter(line -> pattern.matcher(line).find())
            .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
