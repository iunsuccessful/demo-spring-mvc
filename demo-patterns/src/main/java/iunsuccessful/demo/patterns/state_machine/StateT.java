package iunsuccessful.demo.patterns.state_machine;

import java.util.HashMap;
import java.util.Map;

/**
 * 依韵 2020/8/25
 */
abstract class StateT implements State {

    protected Map transitions = null;

    protected void init(Object[][] states) {
        transitions = new HashMap();
        for (int i = 0; i < states.length; i++)
            transitions.put(states[i][0], states[i][1]);
    }

    public abstract void run();

    public State next(Input i) {
        if (transitions.containsKey(i))
            return (State) transitions.get(i);
        else
            throw new RuntimeException(
                    "Input not supported for current state");
    }

}
