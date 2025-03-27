package Multithreading;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){

        System.out.println("Added the item using Producer");
        isItemPresent = true;
        System.out.println("Producer thread is calling notifyAll to release MONITOR LOCK");
        notifyAll();
    }

    public synchronized void consumeItem(){

        // will consume only if there is item
        System.out.println("Consumer thread inside consume item method");
        while (!isItemPresent){
            try {
                // if item is not present, then it will wait
                System.out.println("consumer thread is waiting");
                wait();
            }
            catch (Exception e){
                throw new RuntimeException();
            }
        }
        isItemPresent = false;
        System.out.println("Item is consumed");
    }
}

