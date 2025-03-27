
package Multithreading.CustomLocks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void produce(ReentrantLock reentrantLock) {
        try {
            reentrantLock.lock();
            System.out.println("Thread acquired lock: " + Thread.currentThread().getName() + ", Object: " + this);
            System.out.println("Thread sleeping for 2 seconds.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Thread interrupted: " + Thread.currentThread().getName());
        } finally {
            reentrantLock.unlock();
            System.out.println("Thread released lock: " + Thread.currentThread().getName() + ", Object: " + this);
        }
    }
}