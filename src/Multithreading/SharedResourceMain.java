package Multithreading;

public class SharedResourceMain {

    public static void main(String args[]){

        SharedResource sharedResourceObject = new SharedResource();

        Thread producerThread = new Thread(() -> {
            try {
                // so that consumer thread can reach to consumer function first
                // when no item is present
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResourceObject.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            sharedResourceObject.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }



}
