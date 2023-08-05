package com.bichel.algorithms.math;

/*
Given two numbers, hour and minutes,
return the smaller angle (in degrees)
formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.
 */
public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6; // 360 / 60
        int oneHourAngle = 30; // 360 / 12

        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
