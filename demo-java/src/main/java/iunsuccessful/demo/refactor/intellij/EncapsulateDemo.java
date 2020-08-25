package iunsuccessful.demo.refactor.intellij;

/**
 * 依韵 2020/5/4
 */
public class EncapsulateDemo {

    // Encapsulate Fields
    // public String test;
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
