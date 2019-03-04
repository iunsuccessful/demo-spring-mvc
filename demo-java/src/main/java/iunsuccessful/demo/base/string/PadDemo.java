package iunsuccessful.demo.base.string;

/**
 * 位数补齐到 3 位<br>
 * <p/>
 *
 * @author Created by 依韵 on 2019/1/29 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class PadDemo {

    public static void main(String[] args) {
        String test = String.format("%03d", 20);
        System.out.println(test);
    }

}
