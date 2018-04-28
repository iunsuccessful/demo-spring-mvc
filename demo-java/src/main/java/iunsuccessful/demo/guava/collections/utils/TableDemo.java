package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.function.Consumer;

/**
 * Created by LiQZ on 2018/1/23.
 */
public class TableDemo {

    public static void main(String[] args) {
        Table<String, String, String> demo = HashBasedTable.create();
        demo.put("a", "b", "c");
        demo.put("a", "b", "d");
        demo.put("a", "b", "e");
        demo.put("a", "c", "e");
//        System.out.println(demo.get("a", "b"));
//        System.out.println(demo.row("a"));

        demo.cellSet().forEach(new Consumer<Table.Cell<String, String, String>>() {
            @Override
            public void accept(Table.Cell<String, String, String> cell) {
                System.out.println(cell);
            }
        });



    }

}
