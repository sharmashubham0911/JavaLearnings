package Multithreading.WorkStealingPoolExample;

import java.util.concurrent.RecursiveTask;

public class ComputeTask extends RecursiveTask<Integer> {

    int start, end;

    public ComputeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        System.out.println("Thread is " + Thread.currentThread().getName());
        if (end - start <= 4) {

            int totalSum = 0;
            for (int i = start; i <= end; i++) {
                totalSum += i;
            }

            return totalSum;
        } else {

            int mid = (start + end) / 2;

            // split the task
            ComputeTask leftTask = new ComputeTask(start, mid);
            ComputeTask rightTask = new ComputeTask(mid + 1, end);

            // fork the tasks
            leftTask.fork(); // Fork the left task
            rightTask.fork(); // Fork the right task

            // combine the result
            int leftResult = leftTask.join(); // Join the left task
            int rightResult = rightTask.join(); // Join the right task

            return leftResult + rightResult;
        }
    }
}