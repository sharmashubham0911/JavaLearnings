package Multithreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        Future<List<Integer>> future = executor.submit(() -> {
            try {
                System.out.println("callable is called");
                Thread.sleep(2000);
                System.out.println("Thread is wake up and returning");
                List<Integer> l =  new ArrayList<>();
                l.add(5);
                return l;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            List<Integer> output = future.get();
            System.out.println("output is");
            System.out.println(output.getFirst());
        }
        catch (Exception e){

        }


    }
}
