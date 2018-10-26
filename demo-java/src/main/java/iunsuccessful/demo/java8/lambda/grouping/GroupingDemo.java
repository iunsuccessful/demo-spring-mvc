package iunsuccessful.demo.java8.lambda.grouping;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Create By LiQZ 2018/10/11
 */
public class GroupingDemo {

    public static void main(String[] args) {
        List<Menu> menuList = Menu.data();

//        Map<String, List<Menu>> menuMap = menuList.stream().collect(groupingBy(Menu::getName, toList()));
        Map<String, List<Menu>> menuMap = menuList.stream().collect(groupingBy(Menu::getName, toChild()));
//        Map<Menu, List<Menu>> menuMap = menuList.stream().collect(groupingBy(Menu::getName, toChild()));

        PrintUtils.print(menuMap);

    }

    public static Collector<Menu, ?, List<Menu>> toChild() {
        return new Collector<Menu, List<Menu>, List<Menu>>() {
            @Override
            public Supplier<List<Menu>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiConsumer<List<Menu>, Menu> accumulator() {
                // List::add
                return (menus, e) -> menus.addAll(e.getMenus());
            }

            @Override
            public BinaryOperator<List<Menu>> combiner() {
                return (left, right) -> { left.addAll(right); return left; };
            }

            @Override
            public Function<List<Menu>, List<Menu>> finisher() {
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
            }
        };
    }

}
