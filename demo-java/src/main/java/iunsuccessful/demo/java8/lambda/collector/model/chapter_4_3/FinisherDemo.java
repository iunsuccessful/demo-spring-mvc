package iunsuccessful.demo.java8.lambda.collector.model.chapter_4_3;

import iunsuccessful.demo.common.utils.PrintUtils;
import iunsuccessful.demo.java8.lambda.collector.model.Book;
import iunsuccessful.demo.java8.lambda.collector.model.DataFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 完成器
 * Created by LiQZ on 1/7/2017.
 */
public class FinisherDemo {

    public static void main(String[] args) {
        List<Book> library = DataFactory.getBooks();
        // simple
        String titles = library.stream().map(Book::getTitle).collect(Collectors.joining(";"));
        PrintUtils.print(titles);
        // group by
        Map<Character, String> collect = library.stream().map(Book::getTitle).collect(Collectors.groupingBy(t -> t.charAt(0), Collectors.joining(";")));
        PrintUtils.print(collect);
        // 实际开发中的用法
        Map<Character, List<Book>> collect2 = library.stream().collect(Collectors.groupingBy(t -> t.getTitle().charAt(0)));
        PrintUtils.print(collect2);

    }

}
