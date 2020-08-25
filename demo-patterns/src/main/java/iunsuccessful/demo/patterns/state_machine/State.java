package iunsuccessful.demo.patterns.state_machine;

/**
 * 依韵 2020/8/24
 */
public interface State {

    void run();

    State next(Input i);

}

class Waiting implements State {
    public void run() {
        System.out.println(
                "Waiting: Broadcasting cheese smell");
    }

    public State next(Input i) {
        MouseAction ma = (MouseAction) i;
        if (ma.equals(MouseAction.appears))
            return MouseTrap.luring;
        return MouseTrap.waiting;
    }
}

class Luring implements State {
    public void run() {
        System.out.println(
                "Luring: Presenting Cheese, door open");
    }

    public State next(Input i) {
        MouseAction ma = (MouseAction) i;
        if (ma.equals(MouseAction.runsAway))
            return MouseTrap.waiting;
        if (ma.equals(MouseAction.enters))
            return MouseTrap.trapping;
        return MouseTrap.luring;
    }
}

class Holding implements State {

    public void run() {
        System.out.println("Holding: Mouse caught");
    }

    public State next(Input i) {
        MouseAction ma = (MouseAction) i;
        if (ma.equals(MouseAction.removed))
            return MouseTrap.waiting;
        return MouseTrap.holding;
    }
}

class Trapping implements State {

    public void run() {
        System.out.println("Trapping: Closing door");
    }

    public State next(Input i) {
        MouseAction ma = (MouseAction) i;
        if (ma.equals(MouseAction.escapes))
            return MouseTrap.waiting;
        if (ma.equals(MouseAction.trapped))
            return MouseTrap.holding;
        return MouseTrap.trapping;
    }
}