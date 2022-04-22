package com.bichel.other.tasks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialTaskWithFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();

        Long number = 5l;
        Future<Long> futureTask = threadpool.submit(() -> factorial(number));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println(String.format("factorial of %s is %s", number, result));

        threadpool.shutdown();
    }

    static Long factorial(Long number) {
        Long result = 1l;
        while(number > 1) {
            result *= number--;
        }

        return result;
    }
}
