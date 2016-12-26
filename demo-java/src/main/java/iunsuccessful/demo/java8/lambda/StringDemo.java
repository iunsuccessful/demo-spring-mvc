package iunsuccessful.demo.java8.lambda;



import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author LiQZ on 2016/5/9.
 */
public class StringDemo {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("user1"), new Person("user2"));
        String names = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining("/", "[", "]"));
        System.out.println(names);
        printParams();
    }

    private static void printParams() {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("payTime", "20160510144909");
        params.put("payMethod", "WeChat");
        params.put("orderNo", "32481324");
        params.put("orderNumber", "");
        params.put("key", "alipay");

        String strParams = params.entrySet().stream()
                .filter(e -> !"sign".equals(e.getKey()) && !"key".equals(e.getKey()) && StringUtils.isNotBlank(e.getValue()))
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
                .sorted(Comparator.naturalOrder()) // 等于 sorted(); 这里用的 Tree Map 不需要再排序了
                .collect(Collectors.joining("&"));
        System.out.println(strParams);
        
    }

}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
