package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerSharedResource {

    Queue<Integer> sharedBufferResource;
    int bufferSize;

    public ProducerConsumerSharedResource(int bufferSize){

        sharedBufferResource = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item){

        System.out.println("inside producer");
        // it won't produce if buffer is full
        while (this.sharedBufferResource.size() == this.bufferSize){
            try {
                System.out.println("bufferResource is full, waiting for consumer to consumer");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.sharedBufferResource.offer(item);
        System.out.println("data is produced by producer: " + item);
        notifyAll();
    }

    public synchronized void consume(){

        System.out.println("inside consumer");
        while (this.sharedBufferResource.size() == 0){
            // buffer is empty, wait for producer to add
            System.out.println("bufferResource is empty, waiting for producer to add data");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int consumedData = this.sharedBufferResource.poll();
        notifyAll();
        System.out.println("data is consumed by consumer, consumed data: " + consumedData);
    }


}
