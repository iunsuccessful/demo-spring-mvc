package iunsuccessful.demo.base.reflect;

import java.util.Properties;

/**
 *
 * Created by LiQZ on 2018/4/24.
 */
public class Demo1 {

    public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) {
        System.out.println(Demo1.class.getPackage());
        System.out.println(Demo1.class.getPackage().getImplementationVersion());
        System.out.println(OS_NAME);

        System.getProperties().list(System.out);
    }

}
