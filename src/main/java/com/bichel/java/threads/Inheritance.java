package com.bichel.java.threads;

public class Inheritance {
    public static void main(String[] args) {

        System.out.println("Thread: " + Thread.currentThread().getId() +
                ", name:  " + Thread.currentThread().getName());

        Thread newThread = new SimpleThread();
        newThread.setName("New worker thread");
        newThread.start();
    }
}

class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread: " + this.getId() +
                ", name:  " + this.getName());
    }
}
