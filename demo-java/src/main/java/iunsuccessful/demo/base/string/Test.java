package iunsuccessful.demo.base.string;

import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
//        for (int i = 1; i <= 256; i++) {
        for (int i = 1; i <= 256; i++) {
            String x = String.valueOf(i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;" +
//                    "CREATE  INDEX idx_trade_no ON nuts_change_order_logging_%03d(trade_no(50));", i, i);
//            String y = String.format("DROP INDEX uk_trade_no ON nuts_change_order_logging_%03d;", i);
            String y = String.format("alter table nuts_order_detail_%03d add assemble_basic_num int(11) COMMENT '组合商品基本数量（一份组合商品含有当前商品数量）' after assemble_parent_product_code;", i);

            System.out.println(y);

            System.out.println(String.format("alter table nuts_order_detail_%03d add assemble_num int(11) COMMENT '组合份数(来源与拆分前的 num)' after assemble_basic_num;", i));
        }
    }

}
