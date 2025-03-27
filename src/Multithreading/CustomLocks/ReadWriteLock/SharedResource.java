
package Multithreading.CustomLocks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void produce(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by Thread: " + Thread.currentThread().getName());
            System.out.println("Thread sleeping for 2 seconds: " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Thread interrupted: " + Thread.currentThread().getName());
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock Released by Thread: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock is acquired by thread: " + Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write lock is released by thread: " + Thread.currentThread().getName());
        }
    }
}