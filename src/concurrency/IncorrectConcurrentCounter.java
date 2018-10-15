package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class IncorrectConcurrentCounter extends ConcurrentCounterBase {

    private Long counter = 0L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new IncorrectConcurrentCounter().test();
    }

    @Override
    Callable<Long> incrementCounter() {
        return () -> ++counter;
    }

    @Override
    Long getTotalCount() {
        return counter;
    }
}
