package com.bichel.other.threads;

public class ThreadSafeClass {

    /*
    Here are some points worth remembering to write thread-safe code in Java, this knowledge also helps you to avoid some serious concurrency issues in Java-like race condition or deadlock in Java:

    1) Immutable objects are by default thread-safe because their state can not be modified once created. Since String is immutable in Java, it's inherently thread-safe.
    2) Read-only or final variables in Java are also thread-safe in Java.
    3) Locking is one way of achieving thread-safety in Java.
    4) Static variables if not synchronized properly become a major cause of thread-safety issues.
    5) Example of thread-safe class in Java: Vector, Hashtable, ConcurrentHashMap, String, etc.
    6) Atomic operations in Java are thread-safe like reading a 32-bit int from memory because it's an atomic operation it can't interleave with other threads.
    7) local variables are also thread-safe because each thread has there own copy and using local variables is a good way to write thread-safe code in Java.
    8) In order to avoid thread-safety issues minimize the sharing of objects between multiple threads.
    9) Volatile keyword in Java can also be used to instruct thread not to cache variables and read from main memory and can also instruct basic.JVM not to reorder or optimize code from threading perspective.
     */

    /*
    Thread safety
        There are basically four ways to make variable access safe in shared-memory concurrency:
        * Confinement. Don’t share the variable between threads. This idea is called confinement, and we’ll explore it today.
        * Immutability. Make the shared data immutable. We’ve talked a lot about immutability already, but there are some additional constraints for concurrent programming that we’ll talk about in this reading.
        * Threadsafe data type. Encapsulate the shared data in an existing threadsafe data type that does the coordination for you. We’ll talk about that today.
        * Synchronization. Use synchronization to keep the threads from accessing the variable at the same time. Synchronization is what you need to build your own threadsafe data type.
     */

    /*
    A class and its public APIs are labelled as thread safe if multiple threads
    can consume the exposed APIs without causing race conditions or state corruption for the class.
     Note that composition of two or more thread-safe classes doesn't guarantee the resulting type
     to be thread-safe.
     */

    /*
    Java’s most fundamental construct for thread synchronization is the synchronized keyword. It can be used to restrict access to critical sections one thread at a time.
    Each object in Java has an entity associated with it called the "monitor lock" or just monitor. Think of it as an exclusive lock. Once a thread gets hold of the monitor of an object, it has exclusive access to all the methods marked as synchronized. No other thread will be allowed to invoke a method on the object that is marked as synchronized and will block, till the first thread releases the monitor which is equivalent of the first thread exiting the synchronized method.
     */

    /*
    Note carefully:

        - For static methods, the monitor will be the class object, which is distinct from the monitor of each instance of the same class.
        - If an uncaught exception occurs in a synchronized method, the monitor is still released.
        - Furthermore, synchronized blocks can be re-entered.
     */

    /*

     */

}
