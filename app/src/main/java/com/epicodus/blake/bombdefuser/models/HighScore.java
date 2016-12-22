package com.epicodus.blake.bombdefuser.models;

/**
 * Created by Blake on 12/22/16.
 */

public class HighScore {
    String username;
    long timeLeft;
    int totalClicks;
    String pushId;

    public HighScore() {}

    public HighScore(String username, long timeLeft, int totalClicks) {
        this.timeLeft = timeLeft;
        this.totalClicks = totalClicks;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public String getUsername() {
        return username;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}


