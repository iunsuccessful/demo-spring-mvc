package iunsuccessful.demo.refactor.intellij;

/**
 * 依韵 2020/5/4
 */
public class ExtractSuperClassDemo extends ExtractSuperClassDemo2 {

    protected static String generateText() {
        return "Hello, World!".toUpperCase();
    }

    public void publicMethod() {
        System.out.println("print method");
    }
    public void hiddenMethod() {
        System.out.println("hidden method");
    }

    public static void print() {
        System.out.println(generateText());
    }

}
