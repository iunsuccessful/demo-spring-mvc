package iunsuccessful.demo.apache.collection;

import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.PrintUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By LiQZ 2018/11/16
 */
public class PairDemo {

    /**
     * Excel 导入，错误检测，应该没有 Guava.Table 好用
     */
    public static void main(String[] args) {
        List<Pair<Point, String>> rows = new ArrayList<>();
        Pair<Point, String> row = new ImmutablePair<>(new Point(1, 3), "坐标错误");
        rows.add(row);
        PrintUtils.print(rows);
    }

}

