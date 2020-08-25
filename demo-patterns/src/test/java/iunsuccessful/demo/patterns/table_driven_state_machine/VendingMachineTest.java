package iunsuccessful.demo.patterns.table_driven_state_machine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 依韵 2020/8/25
 */
class VendingMachineTest {

    VendingMachine vm = new VendingMachine();
    Input[] inputs = {
            Money.quarter,
            Money.quarter,
            Money.dollar,
            FirstDigit.A,
            SecondDigit.two,
            FirstDigit.A,
            SecondDigit.two,
            FirstDigit.C,
            SecondDigit.three,
            FirstDigit.D,
            SecondDigit.one,
            Quit.quit,
    };
    @Test
    public void test() {
        for(int i = 0; i < inputs.length; i++)
            vm.nextState(inputs[i]);
    }

}