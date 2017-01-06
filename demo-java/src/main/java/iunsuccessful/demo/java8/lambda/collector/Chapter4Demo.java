package iunsuccessful.demo.java8.lambda.collector;

import iunsuccessful.demo.common.utils.PrintUtils;
import iunsuccessful.demo.java8.lambda.collector.model.Book;
import iunsuccessful.demo.java8.lambda.collector.model.DataFactory;
import iunsuccessful.demo.java8.lambda.collector.model.Topic;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;

/**
 * 第四章演示
 * Created by LiQZ on 2017/1/6.
 */
public class Chapter4Demo {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        demo7();
    }

    private static void demo1() {
        List<Book> library = DataFactory.getBooks();
        Map<Topic, List<Book>> booksByTopic = library.stream().collect(groupingBy(Book::getTopic));
        PrintUtils.print(booksByTopic);
    }

    private static void demo2() {
        List<Book> library = DataFactory.getBooks();
        Map<String, Integer> titleToPubDate = library.stream().collect(toMap(
                Book::getTitle,
                Book::getPubDate,
                BinaryOperator.minBy(Comparator.naturalOrder()), // 出现同名的覆盖规则
                (Supplier<Map<String, Integer>>) TreeMap::new
        ));
        PrintUtils.print(titleToPubDate);
    }

    /**
     * partition: 划分
     */
    private static void demo3() {
        Map<Boolean, List<Book>> fictionOrNon = DataFactory.getBooks().stream().collect(partitioningBy(book -> book.getTopic() == Topic.FICTION));
        PrintUtils.print(fictionOrNon);
    }

    private static void demo4() {
        Map<Topic, Optional<Book>> mostAuthorsByTopic = DataFactory.getBooks().stream()
                .collect(groupingBy(Book::getTopic, maxBy(Comparator.comparing(b -> b.getAuthors().size()))));
        PrintUtils.print(mostAuthorsByTopic);
    }

    private static void demo5() {
        Map<Topic, Integer> volumeCountByTopic = DataFactory.getBooks().stream()
                .collect(groupingBy(Book::getTopic, summingInt(Book::getPageCounts)));
        PrintUtils.print(volumeCountByTopic);
    }

    private static void demo6() {
        Optional<Topic> mostPopularTopic = DataFactory.getBooks().stream()
                .collect(groupingBy(Book::getTopic, counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        PrintUtils.print(mostPopularTopic);
    }

    private static void demo7() {
        Map<Topic, String> concatenatedTitlesByTopic = DataFactory.getBooks().stream()
                .collect(groupingBy(Book::getTopic, mapping(Book::getTitle, joining(";"))));
        PrintUtils.print(concatenatedTitlesByTopic);
    }




}
