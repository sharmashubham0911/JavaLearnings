package Multithreading.CustomLocks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {

        final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        SharedResource resource = new SharedResource();

        Thread readThread1 = new Thread(() -> resource.produce(readWriteLock));
        Thread readThread2 = new Thread(() -> resource.produce(readWriteLock));

        SharedResource resource1 = new SharedResource();

        Thread writeThread = new Thread(() -> resource1.consume(readWriteLock));

        readThread1.start();
        readThread2.start();
        writeThread.start();
    }
}