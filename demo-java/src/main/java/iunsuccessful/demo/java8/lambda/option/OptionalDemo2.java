package iunsuccessful.demo.java8.lambda.option;

import com.google.common.base.MoreObjects;

import java.util.Optional;
import java.util.function.Function;

/**
 * Create By LiQZ 2018/5/8
 */
public class OptionalDemo2 {

    private String name;

    public OptionalDemo2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }

    public static void main(String[] args) {

        OptionalDemo2 od = new OptionalDemo2("od");
        OptionalDemo2 od1 = null;

        OptionalDemo2 od3 = Optional.ofNullable(od1).orElse(od);
        System.out.println(od3);

    }

}
