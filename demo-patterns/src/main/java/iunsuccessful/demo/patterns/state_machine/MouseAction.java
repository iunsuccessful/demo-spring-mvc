package iunsuccessful.demo.patterns.state_machine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 依韵 2020/8/24
 */
public class MouseAction implements Input {

    public static MouseAction
            appears = new MouseAction("mouse appears"),
            runsAway = new MouseAction("mouse runs away"),
            enters = new MouseAction("mouse enters trap"),
            escapes = new MouseAction("mouse escapes"),
            trapped = new MouseAction("mouse trapped"),
            removed = new MouseAction("mouse removed");

    private String action;

    private static List instances = new ArrayList<>();

    public MouseAction(String action) {
        this.action = action;
        instances.add(this);
    }

    public String toString() {
        return action;
    }

    public int hashCode() {
        return action.hashCode();
    }

    public boolean equals(Object o) {
        return (o instanceof MouseAction)
                && action.equals(((MouseAction) o).action);
    }

    public static MouseAction forString(String description) {
        Iterator it = instances.iterator();
        while (it.hasNext()) {
            MouseAction ma = (MouseAction) it.next();
            if (ma.action.equals(description))
                return ma;
        }
        throw new RuntimeException("not found: " + description);
    }



}
