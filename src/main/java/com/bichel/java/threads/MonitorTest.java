package com.bichel.java.threads;

public class MonitorTest {
    /*
    Monitors are advanced concurrency constructs and specific to languages frameworks.
    A monitor is a mutex and then some.
    Monitors are generally language level constructs whereas mutex and semaphore are lower-level or
    OS provided constructs.


    A monitor is made up of a mutex and one or more condition variables.

    in Java each object is a monitor and implicitly has a lock and is a condition variable too.
    You can think of a monitor as a mutex with a wait set.
    Monitors allow threads to exercise mutual exclusion as well as cooperation by allowing them
    to wait and signal on conditions.

    In Java every object is a condition variable and has an associated lock
    that is hidden from the developer. Each java object exposes wait() and notify() methods.


     */

    public static void main(String[] args) {
        Object dummyObject = new Object();

        // Attempting to call wait() on the object
        // outside of a synchronized block.
        //dummyObject.wait();
    }
}

class BadSynchronization {

    public static void main(String args[]) {
        Object dummyObject = new Object();
        Object lock = new Object();

        synchronized (lock) {
            lock.notify();

            // Attempting to call notify() on the object
            // in synchronized block of another object
            dummyObject.notify();
        }
    }
}
