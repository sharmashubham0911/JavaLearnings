package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//         usecase1
//         4 tasks are created
//         minThreads = 2, maxThread = 4
//         QueueSize = 2

//        creating executor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new myCustomThreadFactory(), new myCustomRejectHandler());

        executor.allowCoreThreadTimeOut(true);
//         usecase 1 - creating 4 tasks

        for (int i = 1; i <= 4; i ++){
//            submitting the task
            int finalI = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Task " + finalI + " processed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(100000);

        System.out.println("\n\n\nUsercase - 2");

//                 usecase 2 - creating 5 tasks
//                 One More Thread Will be created
        for (int i = 1; i <= 5; i ++){
//            submitting the task
            int finalI = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task " + finalI + " processed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        System.out.println("\n\nSubmitting 2 more Task");
//        Lets Submit 2 more Task

        for (int i = 6; i <= 7; i ++){
//            submitting the task
            int finalI = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task " + finalI + " processed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();

    }

    static class myCustomThreadFactory implements ThreadFactory {

        private int threadCount = 0;

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "MyCustomThread-" + threadCount++); // Corrected thread creation
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }

    static class myCustomRejectHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            System.out.println("Task Rejected: "  + r.toString());
            System.out.println("Thread Executor is: " + executor.toString());
        }
    }
}
