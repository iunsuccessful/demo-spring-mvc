package iunsuccessful.demo.vavr;

/**
 * 依韵 2021/12/26
 */
public class Person {

    public final String name;
    public final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}
