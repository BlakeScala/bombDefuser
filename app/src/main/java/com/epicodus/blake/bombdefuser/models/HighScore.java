package com.epicodus.blake.bombdefuser.models;

/**
 * Created by Blake on 12/22/16.
 */

public class HighScore {
    long timeLeft;
    int totalClicks;

    public HighScore() {}

    public HighScore(long timeLeft, int totalClicks) {
        this.timeLeft = timeLeft;
        this.totalClicks = totalClicks;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public int getTotalClicks() {
        return totalClicks;
    }
}


