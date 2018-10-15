package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class SynchronizedConcurrentCounter extends ConcurrentCounterBase {

    private Long counter = 0L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new SynchronizedConcurrentCounter().test();
    }

    @Override
    Callable<Long> incrementCounter() {
        return this::increaseCounter;
    }

    @Override
    Long getTotalCount() {
        return getValue();
    }

    private synchronized Long increaseCounter() {
        return ++counter;
    }

    private synchronized Long getValue() {
        return counter;
    }

}
