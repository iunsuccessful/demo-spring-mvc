package iunsuccessful.demo.base.jwt;

/**
 * Create By LiQZ 2018/10/20
 */
public class SuperSonDemo {

    public static void main(String[] args) {
        Son son = new Son();
        son.fun2();
    }

}

class Parent {

    int a = 1;

    public void f() {
        System.out.println("Base:f");
        System.out.println("value = " + a);
    }
}

class Son extends Parent {

    int a = 2;

    @Override
    public void f() {
        System.out.println("Son:f");
        System.out.println("value = " + a);
    }

    public void fun2() {
        super.f();
    }

}
