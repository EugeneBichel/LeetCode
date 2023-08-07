package com.bichel.java;

/*

A CompletableFuture is a class in Java that belongs
to the java.util.concurrent package.
It is used for asynchronous computation.
The code is executed as a non-blocking call in a separate thread, and the result is made available when it is ready.
By doing this, the main thread does not block/wait for the completion of the task, and it can execute other tasks in parallel.

The CompletableFuture class implements the CompletionStage and Future interface. The CompletionStage is a promise. It promises that the computation eventually will be done.
Before Java 8, Future interface, which was added in Java 1.5, was available for asynchronous computation. The limitation of Future interface is that it does not have any methods to combine these computations or handle errors. We will address more limitations of Future interface in the next section.
CompletableFuture has lots of different methods for composing, combining, executing asynchronous computation steps, and handling errors.



 */

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.concurrent.*;
import java.util.stream.Stream;

class CompletableFutureWithblockedGetDemo {

    public static void main(String args[]) {

        //display thread info and about locks
        //jstack -l pid
        //jstack -l 41749
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Long pid = runtimeMXBean.getPid();
        System.out.println(pid);

        Executor executor = Executors.newFixedThreadPool(1);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Start async task");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello World";
        });

        System.out.println("This will print immediately");

        for(int i = 0; i < 1000; i++) {
            System.out.print(i);
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds");

    }
}

class CompletableFutureThenApplyDemo {

    public static void main(String args[]) {

        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenApply() which takes a Function as parameter.
        // It takes a number as input and returns double of number.
        CompletableFuture<Integer> resultFuture = future.thenApply(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        });

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CompletableFutureAllOfDemo {

    public static void main(String args[]) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture<Void> finalFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            finalFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Code that should be executed after all the futures complete.");
    }
}

class CompletableFutureDemo {

    public static void main(String args[]) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        Optional<Integer> maxElement = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join) // This will return the stream of results of all futures.
                .max(Integer::compareTo);

        System.out.println("The max element is " + maxElement);
    }
}

class CompletableFutureAnyOfDemo {

    public static void main(String args[]) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        //The first completed future will be returned.
        CompletableFuture<Object> firstCompletedFuture = CompletableFuture.anyOf(future1, future2, future3);

        try {
            System.out.println("The first completed future value is " + firstCompletedFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Code that should be executed after any of the futures complete.");
    }
}


class CompletableFutureTest {

    public Future<Integer> getSquareAsynchronously(int num) throws InterruptedException {
        CompletableFuture<Integer> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            // The complete() call will complete this CompetableFuture.
            completableFuture.complete(num * num);
            return null;
        });

        return completableFuture;
    }
}
