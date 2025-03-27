package Multithreading.Future;

import java.util.concurrent.*;

public class BasicFutureMethodExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("this is the task which thread will execute");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // caller is checking the status of thread it created

        System.out.println("checking the status of thread " + future.isDone());

        try{
            System.out.println("Again checking if the status is done ");
            future.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Timed Out");
        }

        try{
            System.out.println("waiting for the task to complete");
            future.get();
        } catch (Exception e) {
            System.out.println("Timed Out");
        }


        System.out.println("checking the status of thread " + future.isDone());

        future.cancel(true);
        executor.shutdown();
    }
}
