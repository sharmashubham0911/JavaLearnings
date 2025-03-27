package Multithreading.CustomLocks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(false);

        SharedResource obj1 = new SharedResource();
        SharedResource obj2 = new SharedResource();

        Thread obj1Thread = new Thread(() -> obj1.produce(reentrantLock));
        Thread obj2Thread = new Thread(() -> obj2.produce(reentrantLock));

        System.out.println("Starting Thread 1");
        obj1Thread.start();
        System.out.println("Starting Thread 2");
        obj2Thread.start();
    }
}