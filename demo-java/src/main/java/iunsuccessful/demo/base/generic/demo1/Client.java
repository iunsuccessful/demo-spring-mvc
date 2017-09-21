package iunsuccessful.demo.base.generic.demo1;

/**
 * Created by LiQZ on 2017/9/15.
 */
public class Client {

    public static void main(String[] args) {
        // EntityDao >> HibernateBaseDao >> BaseDao 可以获取
        // EntityDao >> HibernateBaseDao 可以获取
        // HibernateBaseDao 直接放到方法里，可以获取
        // 放到接口 default 也可以获取
        // 直接实现接口无法获取 改为 getGenericInterfaces 就可以了
        EntityDao entityDao = new EntityDao();
        System.out.println(entityDao.getObjectClass());
    }

}
