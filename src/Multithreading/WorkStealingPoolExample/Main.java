package Multithreading.WorkStealingPoolExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = pool.submit(new ComputeTask(0, 100));

        try {
            System.out.println(futureObj.get());
        } catch (ExecutionException e) {
            e.printStackTrace(); // Handle exception properly
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            e.printStackTrace(); // Handle exception properly
        }
    }
}