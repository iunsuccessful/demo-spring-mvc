package iunsuccessful.demo.base.reflect;

import com.google.common.base.MoreObjects;

import java.lang.reflect.Field;

/**
 * Create By LiQZ 2018/7/5
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {

        TestBean bean = new TestBean(false);
        System.out.println(bean.toString());
        // TODO 反射修改为 true
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(bean, true);
        }
        System.out.println(bean.toString());

    }

}

class TestBean {

    private Boolean access;

    public TestBean(Boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("access", access)
                .toString();
    }
}
