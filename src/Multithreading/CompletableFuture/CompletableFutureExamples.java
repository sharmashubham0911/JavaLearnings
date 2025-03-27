package Multithreading.CompletableFuture;

import java.util.concurrent.*;

public class CompletableFutureExamples
{
    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

//        Async Operation

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() ->
                "task completed", poolExecutor);

        try {
            System.out.println(asyncTask1.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return "Hello";
        }, poolExecutor).thenApplyAsync((String val) -> {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return val + "world";
        }). thenApply((String val2) -> {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return val2 + "all";
        });

        try {
            System.out.println(asyncTask2.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return "Hello";
        }, poolExecutor).thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread is: " + Thread.currentThread().getName());
                return val + "world";});
        }).thenComposeAsync((String val2) -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread is: " + Thread.currentThread().getName());
                return val2 + "all";});
        });

        try {
            System.out.println(asyncTask3.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        poolExecutor.shutdown();

    }
}
