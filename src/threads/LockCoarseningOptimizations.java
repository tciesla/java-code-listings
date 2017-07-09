package threads;

import java.util.stream.IntStream;

// Observation: !(taskThreeSynchronizedBlocks <=> taskThreeSynchronizedBlocksMerged)
public class LockCoarseningOptimizations {

    private static final int THREADS_AMOUNT = 10;
    private static final String LOCK = "LOCK";

    public static void main(String[] args) {
        System.out.println("taskThreeSynchronizedBlocks");
        IntStream.range(0, THREADS_AMOUNT).parallel()
                .forEach(LockCoarseningOptimizations::taskThreeSynchronizedBlocks);

        System.out.println("taskThreeSynchronizedBlocksMerged");
        IntStream.range(0, THREADS_AMOUNT).parallel()
                .forEach(LockCoarseningOptimizations::taskThreeSynchronizedBlocksMerged);
    }

    private static void taskThreeSynchronizedBlocks(int thread) {
        synchronized (LOCK) {
            System.out.println(thread + ": statement1");
        }
        synchronized (LOCK) {
            System.out.println(thread + ": statement2");
        }
        synchronized (LOCK) {
            System.out.println(thread + ": statement3");
        }
    }

    private static void taskThreeSynchronizedBlocksMerged(int thread) {
        synchronized (LOCK) {
            System.out.println(thread + ": statement1");
            System.out.println(thread + ": statement2");
            System.out.println(thread + ": statement3");
        }
    }

}
