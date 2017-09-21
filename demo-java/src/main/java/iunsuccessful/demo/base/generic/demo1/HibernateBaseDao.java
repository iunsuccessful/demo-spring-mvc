package iunsuccessful.demo.base.generic.demo1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class HibernateBaseDao<T> implements BaseDao<T> {

    private Class<T> entityClass;

    /**
     * 这个通常也是hibernate的取得子类class的方法
     *
     * @author "yangk"
     * @date 2010-4-11 下午01:51:28
     */
    public HibernateBaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

//    @Override
//    public Class getObjectClass() {
//        return entityClass;
//    }

    @Override
    public T get(String id) {
        try {
            return entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
