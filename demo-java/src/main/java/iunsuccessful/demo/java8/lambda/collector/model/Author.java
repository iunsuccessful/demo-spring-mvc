package iunsuccessful.demo.java8.lambda.collector.model;

/**
 * Created by LiQZ on 2017/1/6.
 */
public class Author {

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
