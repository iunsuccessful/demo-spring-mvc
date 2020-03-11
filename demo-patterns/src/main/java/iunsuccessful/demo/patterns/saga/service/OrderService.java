package iunsuccessful.demo.patterns.saga.service;

import iunsuccessful.demo.patterns.saga.Service;

/**
 * 依韵 2020/1/18
 */
public class OrderService extends Service<String> {

    @Override
    public String getName() {
        return "init an order";
    }

}
