package Multithreading;

public class MonitorLockMain {

    public static void main(String[] args){

        MonitorLockExample obj = new MonitorLockExample();

        // Runnable is functional interface
        // Using lambda to implement run method
        Thread t1 = new Thread(() -> {
            obj.task1();
        });

        Thread t2 = new Thread(() -> {
            obj.task2();
        });

        Thread t3 = new Thread(() -> {
            obj.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
