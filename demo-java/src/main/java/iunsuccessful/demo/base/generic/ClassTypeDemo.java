package iunsuccessful.demo.base.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by LiQZ on 2017/2/17.
 */
public class ClassTypeDemo<T> {

    public Class<T> getDataClass() {
        T t = (T) new Object();
        return (Class<T>) t.getClass();
    }

    public static void main(String[] args) {
        ClassTypeDemo<User> user = new ClassTypeDemo<>();
        System.out.println(user.getDataClass());

    }

}

class User {

}
