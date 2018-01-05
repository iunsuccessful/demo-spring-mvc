package iunsuccessful.demo.base.number;

/**
 * Created by LiQZ on 2017/12/25.
 */
public class SymbolDemo {

    public static void main(String[] args) {
        System.out.printf("%x\n", ~1);
        System.out.println(Integer.toBinaryString(~1));

        // 取偶数位的中间数 ~1 为 1 的补码 1110
        int lo = 0, hi = 5;
        int mid = ((lo + hi) >>> 1) & ~ 1;
        System.out.println(mid);
    }

}
