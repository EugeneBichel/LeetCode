package com.bichel.java.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest<I extends Number> {
    /*
    The Future interface is used to represent the result of an asynchronous computation.
    The interface also provides methods to check the status of a submitted task and
    also allows the task to be cancelled if possible. Without further ado,
    let's dive into an example and see how callable and future objects work in tandem.
    We'll continue with our sumTask example from the previous lesson.
     */

    // Create and initialize a threadpool
    static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    //public static void main( String args[] ) throws Exception {
    //    System.out.println(pollingStatusAndCancelTask(10));
    //    threadPool.shutdown();
    //}

    static int pollingStatusAndCancelTask(final int n) throws Exception {

        int result = -1;

        Callable<Integer> sumTask1 = new Callable<Integer>() {

            public Integer call() throws Exception {

                // wait for 10 milliseconds
                Thread.sleep(10);

                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }
        };

        Callable<Void> randomTask = new Callable<Void>() {

            public Void call() throws Exception {

                // go to sleep for an hours
                Thread.sleep(3600 * 1000);
                return null;
            }
        };

        Future<Integer> f1 = threadPool.submit(sumTask1);
        Future<Void> f2 = threadPool.submit(randomTask);

        // Poll for completion of first task
        try {

            // Before we poll for completion of second task,
            // cancel the second one
            f2.cancel(true);

            // Polling the future to check the status of the
            // first submitted task
            while (!f1.isDone()) {
                System.out.println("Waiting for first task to complete.");
            }
            result = f1.get();
        } catch (ExecutionException ee) {
            System.out.println("Something went wrong.");
        }

        System.out.println("\nIs second task cancelled : " + f2.isCancelled());

        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main( String args[] ) throws Exception{

        FutureTask<Integer> futureTask = new FutureTask(new Callable() {

            public Object call() throws Exception {
                try{
                    Thread.sleep(1);
                }
                catch(InterruptedException ie){
                    // swallow exception
                }
                return 5;
            }
        });

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future duplicateFuture = threadPool.submit(futureTask);

        // Awful idea to busy wait
        while (!futureTask.isDone()) {
            System.out.println("Waiting");
        }

        if(duplicateFuture.isDone() != futureTask.isDone()){
            System.out.println("This should never happen.");
        }

        System.out.println((int)futureTask.get());

        threadPool.shutdown();
    }

    /*
    In the previous lesson we discussed how tasks can be submitted to executors
    but imagine a scenario where you want to submit hundreds or thousands of tasks.
    You'll retrieve the future objects returned from the submit calls and then poll
    all of them in a loop to check which one is done and then take appropriate action.
    Java offers a better way to address this use case through the CompletionService interface.
    You can use the ExecutorCompletionService as a concrete implementation of the interface.
     */

    static Random random = new Random(System.currentTimeMillis());

    //public static void main( String args[] ) throws Exception {
    //    completionServiceExample();
    //}

    static void completionServiceExample() throws Exception {

        class TrivialTask implements Runnable {

            int n;

            public TrivialTask(int n) {
                this.n = n;
            }

            public void run() {
                try {
                    // sleep for one second
                    Thread.sleep(random.nextInt(101));
                    System.out.println(n*n);
                } catch (InterruptedException ie) {
                    // swallow exception
                }
            }
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> service =
                new ExecutorCompletionService<Integer>(threadPool);

        // Submit 10 trivial tasks.
        for (int i = 0; i < 10; i++) {
            service.submit(new TrivialTask(i), new Integer(i));
        }

        // wait for all tasks to get done
        int count = 10;
        while (count != 0) {
            Future<Integer> f = service.poll();
            if (f != null) {
                System.out.println("Thread" + f.get() + " got done.");
                count--;
            }
        }

        threadPool.shutdown();
    }
}

