package com.bichel.other.threads;

public class Basic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(String.format("thread: %s. Name: %s",
                Thread.currentThread().getId(),
                Thread.currentThread().getName()));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("thread: %s. Name: %s",
                        Thread.currentThread().getId(),
                        Thread.currentThread().getName()));
            }
        });

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // log exception inside of the thread
                // clean up resources
            }
        });

        Thread.sleep(2000);

        thread.setName("New worker thread");
        thread.start();
    }
}
