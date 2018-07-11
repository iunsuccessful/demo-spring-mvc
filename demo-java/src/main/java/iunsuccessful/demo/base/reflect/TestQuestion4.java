package iunsuccessful.demo.base.reflect;

import com.google.common.base.MoreObjects;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

/**
 *
 * 请分别用 Java 原生，Spring 反射, Guava 反射, Apache
 *
 * 使用注解+反射控制属性范围
 * * @Min(10) @Max(100)
 *
 * Create By LiQZ 2018/7/11
 */
public class TestQuestion4 {

    public static void main(String[] args){
        springBase();
    }

    private static void springBase() {
        Test4 bean = new Test4();
        System.out.println(bean);
        ReflectionUtils.doWithFields(bean.getClass(),
                new ReflectionUtils.FieldCallback() {
                    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                        RangeInt annotation = field.getAnnotation(RangeInt.class);
                        int min = annotation.min();
                        int max = annotation.max();
                        ReflectionUtils.makeAccessible(field);
                        Integer val = (Integer) ReflectionUtils.getField(field, bean);
                        val = val > max ? max: val;
                        val = val < min ? min: val;
                        ReflectionUtils.setField(field, bean, val);
                    }

                },
                new ReflectionUtils.FieldFilter() {
                    public boolean matches(Field field) {
                        return field.getAnnotation(RangeInt.class) != null;
                    }
                });
        System.out.println(bean);
    }


}

@Retention(RetentionPolicy.RUNTIME)
@interface RangeInt {
    int min();
    int max();
}

class Test4 {

    @RangeInt(min = 10, max = 100)
    private Integer value = 1000;

    private Integer value2 = 1000;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
