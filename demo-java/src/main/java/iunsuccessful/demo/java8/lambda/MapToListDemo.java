package iunsuccessful.demo.java8.lambda;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by LiQZ on 2017/2/21.
 */
public class MapToListDemo {

    public static void main(String[] args) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("beginTime", "12342314231");
        condition.put("endTime", "12342314231");
        condition.put("name", "lmq");

        List<Condition> conditions = condition.entrySet().stream().map(entry -> {
            Condition c = new Condition();
            c.setKey(entry.getKey());
            c.setValue(entry.getValue().toString());
            return c;
        }).collect(Collectors.toList());

        PrintUtils.print(conditions);
    }

}

class Condition {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
