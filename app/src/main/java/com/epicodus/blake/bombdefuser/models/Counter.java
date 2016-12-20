package com.epicodus.blake.bombdefuser.models;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Guest on 12/19/16.
 */
public class Counter extends CountDownTimer {
    private static String hms;
    private static Counter instance;

    private Counter(long millis, long countDownInterval) {
        super(millis,countDownInterval);
    }

    public static Counter initInstance(long millis, long countDownInterval) {
        if (instance == null) {
            instance = new Counter(millis, countDownInterval);
        }
        return instance;
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

    @Override
    public void onTick(long l) {
        long millis = l;
        hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
    }

    public void onFinish() {

    }
}
