package com.bichel.other.threads;

public class ExecutorFramework {
    /*
    Creating and running individual threads for small applications is acceptable however
    if you are writing an enterprise-grade application with several dozen threads
    then you'll likely need to offload thread management in your application
    to library classes which free a developer from worrying about thread house-keeping.
     */

    /*
    A task is a logical unit of work. Usually, a task should be independent of other tasks
    so that it can be completed by a single thread. A task can be represented by an object
    of a class implementing the Runnable interface. We can consider HTTP requests being
    fielded by a web-server as tasks that need to be processed. A database server handling
    client queries can similarly be thought of as independent tasks.
     */

    /*
    Executors are based on consumer-producer patterns.
    The tasks we produce for processing are consumed by threads.
    To better our understanding of how threads behave, imagine you are hired by a hedge fund
    on Wall Street and you are asked to design a method that can process client
    purchase orders as soon as possible. Let's see what are the possible ways to design this method.
     */

    /*
    Thread pools in Java are implementations of the Executor interface or any of its sub-interfaces.
    Thread pools allow us to decouple task submission and execution. We have the option of exposing
    an executor's configuration while deploying an application or switching one executor
    for another seamlessly.
     */

    /*
    A thread pool consists of homogenous worker threads that are assigned to execute tasks.
    Once a worker thread finishes a task, it is returned to the pool.
    Usually, thread pools are bound to a queue from which tasks are dequeued
    for execution by worker threads.
     */

    /*
    void receiveAndExecuteClientOrdersBest() {

        int expectedConcurrentOrders = 100;
        Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);

        while (true) {
            final Order order = waitForNextOrder();

            executor.execute(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
        }
    }
     */

}
