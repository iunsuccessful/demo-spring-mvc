package iunsuccessful.demo.patterns.saga;

import java.util.Optional;

import static iunsuccessful.demo.patterns.saga.Saga.Result.*;

/**
 * 依韵 2020/1/17
 */
public class SagaOrchestrator {

    private Saga saga;

    private ServiceDiscoveryService sd;

    private CurrentState state;

    public SagaOrchestrator(Saga saga, ServiceDiscoveryService sd) {
        this.saga = saga;
        this.sd = sd;
        this.state = new CurrentState();
    }

    public <K> Saga.Result execute(K value) {
        state.cleanUp();
        Saga.Result result = FINISHED;
        K tempVal = value;

        while (true) {
            int next = state.current();
            Saga.Chapter ch = saga.get(next);
            Optional<OrchestrationChapter> srvOpt = sd.find(ch.getName());

            if (srvOpt.isEmpty()) {
                state.directionToBack();
                state.back();
                continue;
            }

            OrchestrationChapter srv = srvOpt.get();

            if (state.isForward()) {
                ChapterResult processRes = srv.process(tempVal);
                if (processRes.isSuccess()) {
                    next = state.forward();
                    tempVal = (K) processRes.getValue();
                } else {
                    state.directionToBack();
                }
            } else {
                ChapterResult rlRes = srv.rollback(tempVal);
                if (rlRes.isSuccess()) {
                    next = state.back();
                    tempVal = (K) rlRes.getValue();
                } else {
                    result = CRASHED;
                    next = state.back();
                }
            }

            if (!saga.isPresent(next)) {
                return state.isForward() ? FINISHED: result == CRASHED ? CRASHED: ROLLBACK;
            }

        }
    }


    private static class CurrentState {

        int currentNumber;

        boolean isForward;

        void cleanUp() {
           currentNumber = 0;
           isForward = true;
        }

        CurrentState() {
            this.currentNumber = 0;
            this.isForward = true;
        }

        boolean isForward() {
            return isForward;
        }

        void directionToBack() {
            isForward = false;
        }

        int forward() {
            return ++currentNumber;
        }

        int back() {
            return --currentNumber;
        }

        int current() {
            return currentNumber;
        }

    }

}
