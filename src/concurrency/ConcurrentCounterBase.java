package concurrency;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

abstract class ConcurrentCounterBase {

    private static final int TASKS_COUNT = 1000;

    void test() throws InterruptedException, ExecutionException {

        // prints information about available processors
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors: " + availableProcessors);

        // creates tasks to perform concurrently
        final Collection<Callable<Long>> tasks = IntStream.range(0, TASKS_COUNT)
                .mapToObj(i -> incrementCounter())
                .collect(toList());

        // creates & invokes tasks on thread pool
        final ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        final List<Future<Long>> futures = executorService.invokeAll(tasks, 10, TimeUnit.SECONDS);

        // waits until all tasks will be finished
        for (Future<Long> future : futures) {
            System.out.println(future.get());
        }

        // prints result
        System.out.println("total: " + getTotalCount());

        executorService.shutdown();
    }

    abstract Callable<Long> incrementCounter();

    abstract Long getTotalCount();

}
