package iunsuccessful.demo.java8.def_interface;

/**
 * Create By LiQZ 2018/12/19
 */
public interface OneInterface {

    default void sayHello() {
        System.out.println("Hello interface");
    }

}
