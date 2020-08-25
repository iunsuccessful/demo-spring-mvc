package iunsuccessful.demo.patterns.table_driven_state_machine;

import java.util.*;

/**
 * 依韵 2020/8/25
 */
public class StateMachine {

    private State state;

    private Map map = new HashMap<>();

    public StateMachine(State initial) {
        this.state = initial;
    }

    /**
     * { {CurrentState},
     *   {Input, Condition(Input), Transition(Input), Next},
     *   {Input, Condition(Input), Transition(Input), Next},
     *   {Input, Condition(Input), Transition(Input), Next},
     * ... }
     */
    public void buildTable(Object[][][] table) {
        for (int i = 0; i < table.length; i++) {
            Object[][] row = table[i];
            Object currentState = row[0][0];

            List transitions = new ArrayList();
            for (int j = 1; j < row.length; j++)
                transitions.add(row[j]);

            map.put(currentState, transitions);
        }
    }

    /**
     * condition 是否状态转移
     * transition 状态转移时，要做哪些操作
     */
    public void nextState(Input input) {
        // transitions
        Iterator it = ((List) map.get(state)).iterator();
        while (it.hasNext()) {
            Object[] tran = (Object[]) it.next();
            if (input == tran[0] || input.getClass() == tran[0]) {
                // condition
                if (tran[1] != null) {
                    Condition c = (Condition) tran[1];
                    if (!c.condition(input))
                        continue; // Failed test
                }
                // transition
                if (tran[2] != null)
                    ((Transition) tran[2]).transition(input);
                // next
                state = (State) tran[3];
                return;
            }
        }
        throw new RuntimeException(
                "Input not supported for current state");
    }

}
