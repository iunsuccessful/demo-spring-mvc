package iunsuccessful.demo.base.string;

import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
        for (int i = 1; i <= 256; i++) {
            String x = String.valueOf(i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;" +
//                    "CREATE  INDEX idx_trade_no ON nuts_change_order_logging_%03d(trade_no(50));", i, i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;", i);
            String y = String.format("CREATE  INDEX idx_trade_no ON nuts_change_order_logging_%03d(trade_no(50));", i);

            System.out.println(y);
        }
    }

}
