package iunsuccessful.demo.java8.lambda;

/**
 * 使用表达式实例化函数接口
 * @author LiQZ on 2016/5/9.
 */
public class OnclickListenerDemo {

    /**
     * <pre>
     * OnClickListener listener = new OnClickListener() {
     *     public void onClick(String v) {
     *         System.out.println(v);
     *     }
     * };
     * </pre>
     */
    public static void main(String[] args) {
        OnClickListener listener = System.out::println;
        listener.onClick("x");
    }

    interface OnClickListener {
        void onClick(String v);
    }

}



