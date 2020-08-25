package iunsuccessful.demo.refactor.intellij;

/**
 * 依韵 2020/5/4
 */
public class FindAndReplaceDuplicateCodeDemo {

    public void method() {
        int a = 1;
        int b = 2;
        int c = a+b;
        int d = b+c;
    }

    public void method2() {
        int a = 1;
        int b = 2;
        int c = a+b;
        int d = b+c;
    }

//    private int add(int a, int b) {
//        return a+b;
//    }


}
