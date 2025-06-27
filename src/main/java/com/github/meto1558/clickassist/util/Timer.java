package com.github.meto1558.clickassist.util;

public class Timer {

    private long startTime;

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public boolean elapsed(long ms) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - startTime) >= ms;
    }

    public void reset() {
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

}
