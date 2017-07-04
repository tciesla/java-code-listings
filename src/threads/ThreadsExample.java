package threads;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class ThreadsExample {

    public static final int ITERATIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        long sequentialDuration = measureDuration(ThreadsExample::sequential);
        System.out.println("Sequential: " + sequentialDuration + " ms\n");
        long parallelDuration = measureDuration(ThreadsExample::parallel);
        System.out.println("Parallel: " + parallelDuration + " ms\n");
    }

    private static void sequential() {
        IntStream.range(0, ITERATIONS)
                .boxed()
                .map(i -> new SomeService("service" + i))
                .forEach(s -> System.out.println(s.getName() + ": " + s.execute() + " ms"));
    }

    private static void parallel() {
        IntStream.range(0, ITERATIONS)
                .parallel()
                .boxed()
                .map(i -> new SomeService("service" + i))
                .forEach(s -> System.out.println(s.getName() + ": " + s.execute() + " ms"));
    }

    private static long measureDuration(Runnable task) {
        long begin = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - begin;
    }
}

class SomeService {

    private final String name;

    public SomeService(String name) {
        this.name = name;
    }

    public long execute() {
        SecureRandom random = new SecureRandom();
        long duration = random.nextInt(10000);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return duration;
    }

    public String getName() {
        return name;
    }
}