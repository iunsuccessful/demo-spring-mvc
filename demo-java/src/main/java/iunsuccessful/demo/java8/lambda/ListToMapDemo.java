package iunsuccessful.demo.java8.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author LiQZ on 2016/9/30.
 */
public class ListToMapDemo {

    /**
     * <code>
             Lists.newArrayList(Module.values()).stream().collect(Collectors.toMap(new Function<Module, Integer>() {
                 @Override
                 public Integer apply(Module module) {
                     return module.getKey();
                 }
             }, new Function<Module, String>() {
                 @Override
                 public String apply(Module module) {
                     return module.getValue();
                 }
             }));
     * </code>
     * @param args
     */
    public static void main(String[] args) {

        // 取元素 key, value
        Map<Integer, String> options = Lists.newArrayList(Module.values()).stream().collect(Collectors.toMap(Module::getKey, Module::getValue));
        options.entrySet().forEach(entry -> System.out.printf("key: %d value: %s", entry.getKey(), entry.getValue()));

        // 取 id， key, Object
        Map<Integer, Module> options2 = Lists.newArrayList(Module.values()).stream().collect(Collectors.toMap(Module::getKey, Function.identity()));
        options2.entrySet().forEach(entry -> System.out.printf("key: %d value: %s", entry.getKey(), entry.getValue()));

    }

    enum Module {

        USER(1, "会员"), PRODUCT(2, "商品");

        private int key;

        private String value;

        Module(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

}
