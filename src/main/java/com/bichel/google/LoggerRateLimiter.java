package com.bichel.google;

import java.util.HashMap;
import java.util.Map;

/*
Design a logger system that receives a stream of messages along with their timestamps.
Each unique message should only be printed at most every 10 seconds
(i.e. a message printed at timestamp t will prevent other identical
messages from being printed until timestamp t + 10).

All messages will come in chronological order.
Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message)
Returns true if the message should be printed in the given timestamp,
otherwise returns false.
 */

public class LoggerRateLimiter {
    private Map<String, Integer> history;

    public LoggerRateLimiter() {
        history = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        boolean shouldPrint = false;

        if(!history.containsKey(message) ||
                timestamp - history.get(message) >= 10) {
            history.put(message, timestamp);
            shouldPrint = true;
        } else {
            shouldPrint = false;
        }

        return shouldPrint;
    }
}
