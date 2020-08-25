package iunsuccessful.demo.refactor.intellij;

import java.util.LinkedList;
import java.util.List;

/**
 * 依韵 2020/5/4
 */
public class GenerifyRefactoringDemo {

    public void method() {
        // before:
//        List list = new LinkedList();
//        list.add("string");
        // after:
        List<String> list = new LinkedList<String>();
        list.add("string");
    }

}
