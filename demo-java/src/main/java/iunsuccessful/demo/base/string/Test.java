package iunsuccessful.demo.base.string;

import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
//        for (int i = 1; i <= 256; i++) {
        for (int i = 1; i <= 2; i++) {
            String x = String.valueOf(i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;" +
//                    "CREATE  INDEX idx_trade_no ON nuts_change_order_logging_%03d(trade_no(50));", i, i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;", i);
//            String y = String.format("alter table nuts_order_detail_%03d add out_of_stock_status int(4) COMMENT '无货状态' after source_refund_detail_id;", i);
            String y = String.format("alter table nuts_order_line_%03d add STOCK_NOT_DELIVERY int(4) COMMENT '无货异常，占不发货' after IS_NOT_DELIVERY;", i);

            System.out.println(y);

//            System.out.println(String.format("alter table nuts_order_detail_%03d add assemble_num int(11) COMMENT '组合份数(来源与拆分前的 num)' after assemble_basic_num;", i));
        }
    }

}
