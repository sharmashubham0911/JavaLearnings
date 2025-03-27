package Multithreading;

public class DeamonJoinPriorityExampleMainClass {

    private synchronized static void callMe(){

        System.out.println("calling callMe method with Thread: " + Thread.currentThread().getName());
        try {
            System.out.println("making the thread: " + Thread.currentThread().getName() + " to sleep for 5s");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " is waking up");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {

        // join examples
        // without join

        System.out.println("inside main, thread is: " + Thread.currentThread().getName());
        Thread t1 = new Thread(()-> callMe());

        System.out.println("starting thread1");
        t1.start();
        System.out.println("Main thread is ended");

//         output of above code will be
//        inside main, thread is: main
//        starting thread1
//        Main thread is ended
//        calling callMe method with Thread: Thread-0
//        making the thread: Thread-0 to sleep for 5s
//        Thread-0 is waking up

        Thread.sleep(10000);
        System.out.println("\n\n\n");
        // using join
        System.out.println("inside main again , thread is: " + Thread.currentThread().getName());
        t1 = new Thread(()-> callMe());
        System.out.println("starting thread1");
        t1.start();
        System.out.println("Main thread is waiting for thread1 to finish");
        t1.join();
        System.out.println("Main thread is ended");

//         output of the above code will be
//        inside main again , thread is: main
//        starting thread1
//        Main thread is waiting for thread1 to finish
//        calling callMe method with Thread: Thread-1
//        making the thread: Thread-1 to sleep for 5s
//        Thread-1 is waking up
//        Main thread is ended


//        Daemon Thread Example
        Thread.sleep(10000);
        System.out.println("\n\n\n");
        System.out.println("This is main thread: Deamon Thread Example");
        t1 = new Thread(() -> {
            callMe();
        });

        t1.setDaemon(true);
        System.out.println("Starting a new daemon thread");
        t1.start();

        System.out.println("Main Thread is ended");

//        Output of the above code Daemon Thread Example
//        This is main thread: Deamon Thread Example
//        Starting a new daemon thread
//        Main Thread is ended
//        calling callMe method with Thread: Thread-2
//        making the thread: Thread-2 to sleep for 5s

//        Thread 2 could not wake up as all the user threads are finished

    }
}
