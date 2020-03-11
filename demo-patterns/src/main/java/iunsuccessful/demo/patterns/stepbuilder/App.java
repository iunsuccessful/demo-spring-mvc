package iunsuccessful.demo.patterns.stepbuilder;

/**
 * 依韵 2019/12/16
 */
public class App {

    public static void main(String[] args) {
        OrderDO orderDO = new OrderDO();

        OrderHeader orderHeader = OrderStepBuilder.newBuilder(orderDO).header().line().detail().build();

    }

}
