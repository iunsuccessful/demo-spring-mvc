package iunsuccessful.demo.patterns.state_machine;

import java.util.Iterator;

/**
 * 依韵 2020/8/24
 */
public class StateMachine {

    private State currentState;

    public StateMachine(State initialState) {
        currentState = initialState;
        currentState.run();
    }

    public final void runAll(Iterator<Input> inputs) {

        while (inputs.hasNext()) {
            Input i = inputs.next();
            System.out.println(i);
            currentState = currentState.next(i);
            currentState.run();
        }

    }

}

class MouseTrap extends StateMachine {
    public static State
            waiting = new Waiting(),
            luring = new Luring(),
            trapping = new Trapping(),
            holding = new Holding();

    public MouseTrap() {
        super(waiting); // Initial state
    }
}
