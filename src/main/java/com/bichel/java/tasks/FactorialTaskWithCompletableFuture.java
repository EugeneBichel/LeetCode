package com.bichel.java.tasks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FactorialTaskWithCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long number = 5l;
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        long result = completableFuture.get();

        System.out.println(String.format("format of %s is %s", number, result));
    }

    static Long factorial(Long number) {
        Long result = 1l;

        while(number > 1) {
            result *= number--;
        }

        return result;
    }
}
