package iunsuccessful.demo.base.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 依韵 2019/11/22
 */
class IntegerDemoTest {

    @Test
    void batchInteger() {

        boolean result = IntegerDemo.batchInteger(10, 1);
        assertTrue(result);
//        assertFalse(result);

    }
}