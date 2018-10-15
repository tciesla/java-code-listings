package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongConcurrentCounter extends ConcurrentCounterBase {

    private final AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new AtomicLongConcurrentCounter().test();
    }

    @Override
    Callable<Long> incrementCounter() {
        return atomicLong::incrementAndGet;
    }

    @Override
    Long getTotalCount() {
        return atomicLong.get();
    }

}
