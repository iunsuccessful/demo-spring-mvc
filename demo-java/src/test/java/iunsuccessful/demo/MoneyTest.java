package iunsuccessful.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 依韵 2019/11/14
 */
class MoneyTest {

    @Test
    void doCalculate() {
        Money.doCalculate(10000.0, 0.1, 22);
    }
}