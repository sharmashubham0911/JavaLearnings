package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);

        poolObj.schedule(() -> {
            System.out.println("Hello");
        }, 3, TimeUnit.SECONDS);


        // repetative
        poolObj.scheduleAtFixedRate(()->{
            System.out.println("Hi");
        }, 4, 2, TimeUnit.SECONDS);

       Thread.sleep(10000);
        poolObj.shutdown();
    }
}
