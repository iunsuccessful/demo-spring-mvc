package iunsuccessful.demo.base.generic.demo1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by LiQZ on 2017/9/15.
 */
public interface BaseDao<T> {

    T get(String id);

    default Class getObjectClass() {
//        Type genType = getClass().getGenericSuperclass();
        Type genType = null;
        Type[] types = getClass().getGenericInterfaces();
        for (Type type: types) {
            System.out.println(type.getTypeName());
            if (type.getTypeName().contains("BaseDao")) {
                genType = type;
            }
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return  (Class) params[0];
    }

}