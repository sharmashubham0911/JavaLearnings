package Multithreading;

public class ProducerConsumerMain {

    public static void main(String[] args){

        ProducerConsumerSharedResource producerConsumerSharedResourceObj = new ProducerConsumerSharedResource(3);

        // creating producer thread using lambda expression
        Thread producer = new Thread(() ->{

            for(int i = 1; i <=6; i ++){
                try {
                    producerConsumerSharedResourceObj.produce(i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        // creating consumer thread using lambda expression
        Thread consumer = new Thread(() ->{

            for(int i = 1; i <=6; i ++){
                try {
                    producerConsumerSharedResourceObj.consume();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
