package com.bichel.java.threads;

public class JavaSyncronized {
    /*
        another common approach that we can use for achieving thread-safety is implementing synchronized methods.
        Simply put, only one thread can access a synchronized method at a time while blocking access to this method from other threads. Other threads will remain blocked until the first thread finishes or the method throws an exception.
        We can create a thread-safe version of incrementCounter() in another way by making it a synchronized method:

        public synchronized void incrementCounter() {
            counter += 1;
        }
        We've created a synchronized method by prefixing the method signature with the synchronized keyword.
        Since one thread at a time can access a synchronized method, one thread will execute the incrementCounter() method, and in turn, others will do the same. No overlapping execution will occur whatsoever.
        Synchronized methods rely on the use of “intrinsic locks” or “monitor locks”. An intrinsic lock is an implicit internal entity associated with a particular class instance.

        In a multithreaded context, the term monitor is just a reference to the role that the lock performs on the associated object, as it enforces exclusive access to a set of specified methods or statements.
        When a thread calls a synchronized method, it acquires the intrinsic lock. After the thread finishes executing the method, it releases the lock, hence allowing other threads to acquire the lock and get access to the method.
        We can implement synchronization in instance methods, static methods, and statements (synchronized statements).

        Sometimes, synchronizing an entire method might be overkill if we just need to make a segment of the method thread-safe.
        To exemplify this use case, let's refactor the incrementCounter() method:
        public void incrementCounter() {
            // additional unsynced operations
            synchronized(this) {
                counter += 1;
            }
        }
        The example is trivial, but it shows how to create a synchronized statement. Assuming that the method now performs a few additional operations, which don't require synchronization, we only synchronized the relevant state-modifying section by wrapping it within a synchronized block.
        Unlike synchronized methods, synchronized statements must specify the object that provides the intrinsic lock, usually the this reference.
        Synchronization is expensive, so with this option, we are able to only synchronize the relevant parts of a method.

        We can slightly improve the thread-safe implementation of the Counter class by exploiting another object as a monitor lock, instead of this.
        Not only does this provide coordinated access to a shared resource in a multithreaded environment, but also it uses an external entity to enforce exclusive access to the resource:
        public class ObjectLockCounter {

            private int counter = 0;
            private final Object lock = new Object();

            public void incrementCounter() {
                synchronized(lock) {
                    counter += 1;
                }
            }

            // standard getter
        }
        We use a plain Object instance to enforce mutual exclusion. This implementation is slightly better, as it promotes security at the lock level.
        When using this for intrinsic locking, an attacker could cause a deadlock by acquiring the intrinsic lock and triggering a denial of service (DoS) condition.

        Caveats
        Even though we can use any Java object as an intrinsic lock, we should avoid using Strings for locking purposes:
        public class Class1 {
            private static final String LOCK  = "Lock";

            // uses the LOCK as the intrinsic lock
        }

        public class Class2 {
            private static final String LOCK  = "Lock";

            // uses the LOCK as the intrinsic lock
        }
        At first glance, it seems that these two classes are using two different objects as their lock. However, because of string interning, these two “Lock” values may actually refer to the same object on the string pool. That is, the Class1 and Class2 are sharing the same lock!
        This, in turn, may cause some unexpected behaviors in concurrent contexts.
        In addition to Strings, we should avoid using any cacheable or reusable objects as intrinsic locks. For example, the Integer.valueOf() method caches small numbers. Therefore, calling Integer.valueOf(1) returns the same object even in different classes.
     */

    /*

    Reentrant Locks
        Java provides an improved set of Lock implementations, whose behavior is slightly more sophisticated than the intrinsic locks discussed above.
        With intrinsic locks, the lock acquisition model is rather rigid: one thread acquires the lock, then executes a method or code block, and finally releases the lock, so other threads can acquire it and access the method.
        There's no underlying mechanism that checks the queued threads and gives priority access to the longest waiting threads.
        ReentrantLock instances allow us to do exactly that, hence preventing queued threads from suffering some types of resource starvation:
        public class ReentrantLockCounter {

            private int counter;
            private final ReentrantLock reLock = new ReentrantLock(true);

            public void incrementCounter() {
                reLock.lock();
                try {
                    counter += 1;
                } finally {
                    reLock.unlock();
                }
            }

            // standard constructors / getter

        }
        The ReentrantLock constructor takes an optional fairness boolean parameter. When set to true, and multiple threads are trying to acquire a lock, the basic.JVM will give priority to the longest waiting thread and grant access to the lock.
     */

    /*

        Read/Write Locks
        Another powerful mechanism that we can use for achieving thread-safety is the use of ReadWriteLock implementations.
        A ReadWriteLock lock actually uses a pair of associated locks, one for read-only operations and other for writing operations.
        As a result, it's possible to have many threads reading a resource, as long as there's no thread writing to it. Moreover, the thread writing to the resource will prevent other threads from reading it.
        We can use a ReadWriteLock lock as follows:
        public class ReentrantReadWriteLockCounter {

            private int counter;
            private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
            private final Lock readLock = rwLock.readLock();
            private final Lock writeLock = rwLock.writeLock();

            public void incrementCounter() {
                writeLock.lock();
                try {
                    counter += 1;
                } finally {
                    writeLock.unlock();
                }
            }

            public int getCounter() {
                readLock.lock();
                try {
                    return counter;
                } finally {
                    readLock.unlock();
                }
            }

           // standard constructors

        }

     */
}
