package iunsuccessful.demo.java8.lambda.collector.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 示例数据生成器
 * Created by LiQZ on 2017/1/6.
 */
public class DataFactory {

    private DataFactory() {

    }

    public static List<Book> getBooks() {
        List<Book> books = Lists.newArrayList();

        Book book = new Book();
        book.setPageCounts(100);
        book.setPubDate((int) (System.currentTimeMillis() / 1000));
        book.setTitle("孔雀东南飞");
        book.setTopic(Topic.FICTION);
        book.setAuthors(getAuthers("佚名"));
        books.add(book);

        Book book2 = new Book();
        book2.setPageCounts(50);
        book2.setPubDate((int) (System.currentTimeMillis() / 1000));
        book2.setTitle("史记");
        book2.setTopic(Topic.HISTORY);
        book2.setAuthors(getAuthers("司马迁"));
        books.add(book2);

        Book book3 = new Book();
        book3.setPageCounts(200);
        book3.setPubDate((int) (System.currentTimeMillis() / 1000));
        book3.setTitle("全球通史");
        book3.setTopic(Topic.HISTORY);
        book3.setAuthors(getAuthers("斯塔夫里阿诺斯", "吴象婴"));
        books.add(book3);

        Book book4 = new Book();
        book4.setPageCounts(32);
        book4.setPubDate((int) (System.currentTimeMillis() / 1000));
        book4.setTitle("Spark 最佳实践");
        book4.setTopic(Topic.IT);
        book4.setAuthors(getAuthers("陈欢", "林世飞"));
        books.add(book4);

        Book book5 = new Book();
        book5.setPageCounts(452);
        book5.setPubDate((int) (System.currentTimeMillis() / 1000));
        book5.setTitle("Spark 高级数据分析");
        book5.setTopic(Topic.IT);
        book5.setAuthors(getAuthers("里扎","Uri Laserson","Sean Owen","Josh Wills", "龚少成"));
        books.add(book5);


        return books;
    }

    public static List<Author> getAuthers(String... authorNames) {
        List<Author> authors = Lists.newArrayList();
        for (int i = 0; i < authorNames.length; i++ ) {
            authors.add(new Author(authorNames[i]));
        }
        return authors;
    }

}
