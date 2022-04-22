package com.bichel.other.threads;

public class HoaraVsMesaMonitors {
    /*
    So far we have determined that the idiomatic usage of a monitor requires using a while loop as follows. Let's see how the design of monitors affects this recommendation.


while( condition == false ) {
    condVar.wait();
}

Once the asleep thread is signaled and wakes up, you may ask why does it need to check for the condition being false again, the signaling thread must have just set the condition to true?

In Mesa monitors - Mesa being a language developed by Xerox researchers in the 1970s - it is possible that the time gap between thread B calls notify() and releases its mutex and the instant at which the asleep thread A, wakes up and reacquires the mutex, the predicate is changed back to false by another thread different than the signaler and the awoken threads! The woken up thread competes with other threads to acquire the mutex once the signaling thread B empties the monitor. On signaling, thread B doesn't give up the monitor just yet; rather it continues to own the monitor until it exits the monitor section.

In contrast, Hoare monitors - Hoare being one of the original inventor of monitors - the signaling thread B yields the monitor to the woken up thread A and thread A enters the monitor, while thread B sits out. This guarantees that the predicate will not have changed and instead of checking for the predicate in a while loop an if-clause would suffice. The woken-up/released thread A immediately starts execution when the signaling thread B signals that the predicate has changed. No other thread gets a chance to change the predicate since no other thread gets to enter the monitor.

Java, in particular, subscribes to Mesa monitor semantics and the developer is always expected to check for condition/predicate in a while loop. Mesa monitors are more efficient than Hoare monitors.
     */
}
