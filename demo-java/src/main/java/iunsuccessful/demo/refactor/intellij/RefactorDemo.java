package iunsuccessful.demo.refactor.intellij;

/**
 * Intellij Idea 右键 Refactor 里各方法的作用
 * 依韵 2020/5/2
 */
public class RefactorDemo {

    // 1. Use Move Members d to -> RefactorDemo2
    // static int d;
    // 2 Use Copy Class to copy RefactorDemo

    public static void main(String[] args) {
        int c = Test.invoke();
//        RefactorDemo2.d = c + a;
        System.out.println(c);
    }


    /**
     * 3. Use Replace Method with Method Object
     * before:
     *  int a = 1;
     *  int b = 2;
     *  int c = a + b;
     * after:
     *  int c = Test.invoke();
     *
     * 4. Use Inline Method can back off.
     */
    private static class Test {
        private static int invoke() {
            int a = 1;
            int b = 2;
            return a + b;
        }
    }
}
