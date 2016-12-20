package com.epicodus.blake.bombdefuser.models;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Guest on 12/19/16.
 */
public class Counter {
    private static String hms;
    private static Counter instance;
    public long millis;
    public long countdownInterval;

    public Counter(long millis, long countDownInterval) {
        this.millis = millis;
        this.countdownInterval = countDownInterval;
    }


    public static Counter getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("not instantiated");
        } else {
            return instance;
        }
    }

    public static String getFormattedTime() {
        return hms;
    }

    public void createCountdown() {
        CountDownTimer timer = new CountDownTimer(this.millis, this.countdownInterval) {
            @Override
            public void onTick(long timeLeft) {
                long millis = timeLeft;
                String hms = String.format("%02d:%02d",
                        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis) - java.util.concurrent.TimeUnit.HOURS.toMinutes(java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millis)),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millis) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis))
                );
                String timeLeftString = String.valueOf((timeLeft / 1000));
            }

            @Override
            public void onFinish() {
                // Take to loser's page!
            }
        };
        timer.start();
    }
}
