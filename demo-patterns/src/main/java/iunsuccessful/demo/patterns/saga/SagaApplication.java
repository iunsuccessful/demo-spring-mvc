package iunsuccessful.demo.patterns.saga;

import iunsuccessful.demo.patterns.saga.service.OrderService;

/**
 * 依韵 2020/1/18
 */
public class SagaApplication {

    public static void main(String[] args) {
        SagaOrchestrator sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());

        var result = sagaOrchestrator.execute("init an order");
        System.out.println(result);
    }

    private static Saga newSaga() {
        return Saga
                .create()
                .chapter("init an order");
    }

    private static ServiceDiscoveryService serviceDiscovery() {
        return new ServiceDiscoveryService().discover(new OrderService());
    }

}
