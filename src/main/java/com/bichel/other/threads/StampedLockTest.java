package com.bichel.other.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    /*
    Before Java 8 we had a ReentrantReadWriteLock class that was used for reading and writing data in a thread-safe manner.

    Here are a few of the important points about ReentrantReadWriteLock:
        Multiple threads can acquire a read lock simultaneously.
        Only one thread can acquire a write lock.
        If a thread wants to acquire a write lock and there are some threads that have read lock, the thread will wait until all the threads release the read lock.
        There are a few problems with using the ReentrantReadWriteLock class:

    It can lead to starvation.
    Sometimes it can be significantly slower than other synchronizers.

    To overcome these disadvantages, StampedLock is added. Apart from providing separate read and write locks, also has a feature for optimistic locking for reading operations.
    StampedLock also provides a method to upgrade read lock to write lock, which is not in ReentrantReadWriteLock in Java.

    The StampedLock class provides three locking modes:
        Read
        Write
        Optimistic read


    Non blocking lock methods #
    The readLock() and writeLock() methods discussed above are blocking methods. This means that if a thread t1 tries to acquire a read lock and some other thread, like t2 has already acquired a write lock, the thread t1 will block.

    If we want, our thread should not block. We can use one of the following methods:

    tryReadLock() - Acquire the lock if it is immediately available otherwise don’t block.
    tryWriteLock() - Acquire the lock if it is immediately available otherwise don’t block.
    tryReadLock(long time, TimeUnit unit) - Try to acquire the lock till the provided time limit.
    tryWriteLock(long time, TimeUnit unit) - Try to acquire the lock until the provided time limit.


    Optimized reading #
    Acquiring and releasing a lock is a costly process and can lead to starvation.

    Suppose we have a use case where data is read frequently but rarely updated. In this case, it is not advisable to get a read lock every time we are reading.

    In such situations, we can use tryOptimisticRead() for our reading operations. Here is how tryOptimisticRead() works.

    Suppose thread t1 tries to get an optimistic lock

    If some other thread has already acquired a write lock, thread t1 returns. It is not able to acquire the lock.
    If some other thread has already acquired a read lock then tryOptimisticRead() returns an observation stamp.



     */
}


class StampedLockDemo {

    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    // Method to read data from the Map.
    public static Integer readDataFromMap(String key) {

        long stamp = lock.readLock();
        try {
            return data.get(key);
        } finally {
            lock.unlockRead(stamp);
        }
    }

    // Method to write data to the Map.
    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.writeLock();
        try {
            data.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String args[]){
        writeDataToMap("ray", 123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}


class StampedTryLockDemo {

    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    //Method to read data from the Map. Since we are using tryReadLock(), the thread will not block.
    public static Integer readDataFromMap(String key) {

        long stamp = lock.tryReadLock();
        int result = 0;
        if(stamp != 0L){
            try {
                result = data.get(key);
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return result;
    }

    //Method to write data to the Map. Since we are using tryWriteLock(), the thread will not block.
    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.tryWriteLock();
        if(stamp != 0L){
            try {
                data.put(key, value);
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String args[]){
        writeDataToMap("ray",123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}

class StampedOptimisticLockDemo {

    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    public static Integer readDataFromMap(String key) {
        int result = 0;
        long stamp = lock.tryOptimisticRead();

        if(stamp != 0L){
            result = data.get(key);
        }

        if (!lock.validate(stamp)) {
            // This means that the data was modified after we called optimistic read.
            // Do extra work here to get the latest data.
        }
        return result;
    }

    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.tryWriteLock();
        if(stamp != 0L){
            try {
                data.put(key, value);
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String args[]){
        writeDataToMap("ray",123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}