package iunsuccessful.demo.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/3/25 .
 */
public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(toString_02(e));
        }

    }

    public static void test() {
        if (true) {
            throw new RuntimeException();
        }
    }

    /**
     * 保存堆栈信息
     * @param e
     * @return
     */
    private static String toString_02(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

}
