package iunsuccessful.demo.java8.lambda.collector;

import com.google.common.collect.Ordering;
import iunsuccessful.demo.common.utils.PrintUtils;
import iunsuccessful.demo.java8.lambda.collector.model.Book;
import iunsuccessful.demo.java8.lambda.collector.model.DataFactory;
import iunsuccessful.demo.java8.lambda.collector.model.Topic;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * 第四章演示
 * Created by LiQZ on 2017/1/6.
 */
public class Chapter4Demo {

    public static void main(String[] args) {
        demo1();
        demo2();
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
                BinaryOperator.minBy(Comparator.naturalOrder()),
                (Supplier<Map<String, Integer>>) TreeMap::new
        ));
        PrintUtils.print(titleToPubDate);
    }

    public static void demo3() {

    }




}
