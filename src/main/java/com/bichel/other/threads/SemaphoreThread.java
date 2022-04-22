package com.bichel.other.threads;

public class SemaphoreThread {
    /*
    Semaphore, on the other hand, is used for limiting access to a collection of resources.
    Think of semaphore as having a limited number of permits to give out.
    If a semaphore has given out all the permits it has, then any new thread
    that comes along requesting for a permit will be blocked,
    till an earlier thread with a permit returns it to the semaphore.
    A typical example would be a pool of database connections that can be
    handed out to requesting threads. Say there are ten available connections
    but 50 requesting threads. In such a scenario, a semaphore can only give out
    ten permits or connections at any given point in time.

    A semaphore with a single permit is called a binary semaphore and is often thought of as
    an equivalent of a mutex, which isn't completely correct as we'll shortly explain.
    Semaphores can also be used for signaling among threads. This is an important
    distinction as it allows threads to cooperatively work towards completing a task.
    A mutex, on the other hand, is strictly limited to serializing access to shared state
    among competing threads.
     */

    /*
    Mutex implies mutual exclusion and is used to serialize access to critical sections whereas semaphore can potentially be used as a mutex but it can also be used for cooperation and signaling amongst threads. Semaphore also solves the issue of missed signals.
    Mutex is owned by a thread, whereas a semaphore has no concept of ownership.
    Mutex if locked, must necessarily be unlocked by the same thread. A semaphore can be acted upon by different threads. This is true even if the semaphore has a permit of one
    Think of semaphore analogous to a car rental service such as Hertz. Each outlet has a certain number of cars, it can rent out to customers. It can rent several cars to several customers at the same time but if all the cars are rented out then any new customers need to be put on a waitlist till one of the rented cars is returned. In contrast, think of a mutex like a lone runway on a remote airport. Only a single jet can land or take-off from the runway at a given point in time. No other jet can use the runway simultaneously with the first aircraft.
     */
}
