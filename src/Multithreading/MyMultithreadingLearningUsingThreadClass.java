package Multithreading;

public class MyMultithreadingLearningUsingThreadClass extends Thread{

    @Override
    public void run() {

        System.out.println("Code executed by thread inside class MyMultithreadingLearningUsingThreadClass: " + Thread.currentThread().getName());
    }
}
