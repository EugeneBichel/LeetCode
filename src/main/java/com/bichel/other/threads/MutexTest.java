package com.bichel.other.threads;

public class MutexTest {
    /*
    Mutex as the name hints implies mutual exclusion.
    A mutex is used to guard shared data such as a linked-list, an array or any primitive type.
    A mutex allows only a single thread to access a resource or critical section.
    Once a thread acquires a mutex, all other threads attempting to acquire
    the same mutex are blocked until the first thread releases the mutex.
    Once released, most implementations arbitrarily chose one of the waiting threads
    to acquire the mutex and make progress.
     */

    /*
    Mutex implies mutual exclusion and is used to serialize access to critical sections whereas semaphore can potentially be used as a mutex but it can also be used for cooperation and signaling amongst threads. Semaphore also solves the issue of missed signals.
    Mutex is owned by a thread, whereas a semaphore has no concept of ownership.
    Mutex if locked, must necessarily be unlocked by the same thread. A semaphore can be acted upon by different threads. This is true even if the semaphore has a permit of one
    Think of semaphore analogous to a car rental service such as Hertz. Each outlet has a certain number of cars, it can rent out to customers. It can rent several cars to several customers at the same time but if all the cars are rented out then any new customers need to be put on a waitlist till one of the rented cars is returned. In contrast, think of a mutex like a lone runway on a remote airport. Only a single jet can land or take-off from the runway at a given point in time. No other jet can use the runway simultaneously with the first aircraft.
     */


}