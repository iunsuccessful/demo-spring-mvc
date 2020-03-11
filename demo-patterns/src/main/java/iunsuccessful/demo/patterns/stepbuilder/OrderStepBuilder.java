package iunsuccessful.demo.patterns.stepbuilder;

import java.util.Collections;

/**
 * 依韵 2019/12/16
 */
public class OrderStepBuilder {

    private OrderStepBuilder() {
    }

    public static OrderHeaderStep newBuilder(OrderDO orderDO) {
        return new OrderSteps(orderDO);
    }

    public interface OrderHeaderStep {
        OrderLineStep header();
    }

    public interface OrderLineStep {
        OrderDetailStep line();
    }

    public interface OrderDetailStep {
        BuildStep detail();
    }

    public interface BuildStep {
        OrderHeader build();
    }

    private static class OrderSteps implements OrderHeaderStep, OrderLineStep, OrderDetailStep, BuildStep {

        private OrderDO orderDO;

        private OrderHeader orderHeader;
        private OrderLine orderLine;
        private OrderDetail orderDetail;

        public OrderSteps(OrderDO orderDO) {
            this.orderDO = orderDO;
        }

        @Override
        public OrderLineStep header() {
            this.orderHeader = new OrderHeader();
            return this;
        }

        @Override
        public OrderDetailStep line() {
            this.orderLine = new OrderLine();
            return this;
        }

        @Override
        public BuildStep detail() {
            this.orderDetail = new OrderDetail();
            return this;
        }

        @Override
        public OrderHeader build() {
            this.orderLine.setDetails(Collections.singletonList(orderDetail));
            this.orderHeader.setLines(Collections.singletonList(this.orderLine));
            return this.orderHeader;
        }
    }


}
