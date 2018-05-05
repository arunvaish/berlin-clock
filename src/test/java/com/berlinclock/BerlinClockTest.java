package com.berlinclock;


import org.junit.Test;

public class BerlinClockTest {

    @Test
    public void testInitialTime() {
        new BerlinClock("00:00:00");
    }

    @Test
    public void testHeighestTime() {
        new BerlinClock("23:59:59");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHours() {
        new BerlinClock("24:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinutes() {
        new BerlinClock("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSeconds() {
        new BerlinClock("00:00:60");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHoursNegative() {
        new BerlinClock("-05:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinutesNegative() {
        new BerlinClock("00:-02:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSecondsNegative() {
        new BerlinClock("00:00:-03");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTime() {
        new BerlinClock("11:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        new BerlinClock(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTime() {
        new BerlinClock("");
    }
}
