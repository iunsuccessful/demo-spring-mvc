package iunsuccessful.demo.base.reflect;

import com.google.common.base.MoreObjects;
import com.google.common.reflect.Reflection;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 *
 * 请分别用 Java 原生，Spring 反射, Guava 反射, Apache
 *
 * 设置一个类的私有属性
 *
 * Create By LiQZ 2018/7/11
 */
public class TestQuestion {

    public static void main(String[] args) throws Exception {
//        javaBase();
//        springBase();
//        guavaBase();
        apacheBase();
    }

    /**
     * java 基本方法实现
     * fields 只能获取公开的属性
     * getDeclaredField 可以获取到私有属性
     */
    private static void javaBase() throws Exception {
        Test t = new Test();
        System.out.println(t);
        // Public
        Field fieldPub = t.getClass().getField("b");
//        Field fieldB = FieldUtil.getField(Test.class, "b");
        fieldPub.set(t, true);
        // Private
        Field fieldPri = t.getClass().getDeclaredField("a");
        fieldPri.setAccessible(true);
        fieldPri.set(t, true);
        System.out.println(t);
    }

    /**
     * Spring 的 public 也要 make accessible
     */
    private static void springBase() {
        Test t = new Test();
        System.out.println(t);
        Field fieldPri = ReflectionUtils.findField(Test.class, "a");
        Field fieldPub = ReflectionUtils.findField(Test.class, "b");
        ReflectionUtils.makeAccessible(fieldPri);
        ReflectionUtils.makeAccessible(fieldPub);
        ReflectionUtils.setField(fieldPri, t, true);
        ReflectionUtils.setField(fieldPub, t, true);
        System.out.println(t);
    }

    private static void guavaBase() {
        Test t = new Test();
        System.out.println(t);

    }

    private static void apacheBase() throws Exception {
        Test t = new Test();
        System.out.println(t);
        FieldUtils.writeDeclaredField(t, "a", true, true);
        FieldUtils.writeDeclaredField(t, "b", true);
        System.out.println(t);
    }

}

class Test {

    private Boolean a;

    public boolean b;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("a", a)
                .add("b", b)
                .toString();
    }
}
