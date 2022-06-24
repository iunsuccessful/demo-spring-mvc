package iunsuccessful.demo.base.list;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 依韵 2022/6/24
 */
public class CountElementInListDemo {

    public static void main(String[] args) {
        List<String> INPUT_LIST = Arrays.asList(
                "expect1",
                "expect2", "expect2",
                "expect3", "expect3", "expect3",
                "expect4", "expect4", "expect4", "expect4");

        System.out.println(countByForEachLoopWithMapCompute(INPUT_LIST));

    }

    public static <T> Map<T, Long> countByForEachLoopWithMapCompute(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));
        return resultMap;
    }

}
