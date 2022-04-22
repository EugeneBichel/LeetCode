package com.bichel.other.threads;

public class WaitAndNotify {
    /*
    The wait method is exposed on each java object.
    Each Java object can act as a condition variable.
    When a thread executes the wait method, it releases the monitor for the object
    and is placed in the wait queue. Note that the thread must be inside a synchronized block
    of code that synchronizes on the same object as the one on which wait() is being called,
    or in other words, the thread must hold the monitor of the object on which it'll call wait.
    If not so, an illegalMonitor exception is raised!
     */

    /*
    Like the wait method, notify() can only be called by the thread which owns the monitor
    for the object on which notify() is being called else an illegal monitor exception is thrown.
    The notify method, will awaken one of the threads in the associated wait queue, i.e.,
    waiting on the thread's monitor.
    However, this thread will not be scheduled for execution immediately and will compete
    with other active threads that are trying to synchronize on the same object.
    The thread which executed notify will also need to give up the object's monitor,
    before any one of the competing threads can acquire the monitor and proceed forward.
     */

    /*
    notifyAll()

    This method is the same as the notify() one except
    that it wakes up all the threads that are waiting on the object's monitor.
     */

}
