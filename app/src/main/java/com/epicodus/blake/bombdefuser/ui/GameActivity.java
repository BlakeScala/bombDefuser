package com.epicodus.blake.bombdefuser.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.blake.bombdefuser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.levelOneButton) Button mLevelOneButton;
    @Bind(R.id.levelTwoButton) Button mLevelTwoButton;
    @Bind(R.id.clockTimerView) TextView mClockTimerView;
    @Bind(R.id.levelContainer) FrameLayout mLevelContainer;

    SwitchOneFragment levelOne;
    SwitchTwoFragment levelTwo;
    SwitchThreeFragment levelThree;

    int levelOneTotalClicks;
    int levelTwoTotalClicks;

    FragmentTransaction transaction;
    boolean levelOneStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ButterKnife.bind(this);
        mLevelOneButton.setOnClickListener(this);


        CountDownTimer timer = new CountDownTimer(180000, 1000) {
            @Override
            public void onTick(long timeLeft) {
                long millis = timeLeft;
                String hms = String.format("%02d:%02d",
                        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis) - java.util.concurrent.TimeUnit.HOURS.toMinutes(java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millis)),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millis) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis))
                );
                String timeLeftString = String.valueOf((timeLeft/1000));
                mClockTimerView.setText(hms);


                if (levelOneStarted) {
                    if (levelOneDone()) {
                        getSupportFragmentManager().beginTransaction().remove(levelOne).commit();
                    }
                }
            }

            @Override
            public void onFinish() {
                // Take to loser's page!
            }
        };
        timer.start();
    }

    public void onClick(View v) {
        if (v == mLevelOneButton) {
            levelOneStarted = true;
            levelOne = new SwitchOneFragment();

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.levelContainer, levelOne);
            transaction.commit();
        }
        if (v == mLevelTwoButton) {
            levelTwo = new SwitchTwoFragment();

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.levelContainer, levelTwo);
            transaction.commit();
        }
    }
    public boolean levelOneDone() {
        if(levelOne.puzzleIsCompleted()) {
            levelOneTotalClicks = levelOne.getTotalClicks();
            mLevelOneButton.setOnClickListener(null);
            mLevelTwoButton.setOnClickListener(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean levelTwoCompleted() {
        if (levelTwo.puzzleIsCompleted()) {
            levelTwoTotalClicks = levelTwo.getTotalClicks();
            mLevelTwoButton.setOnClickListener(null);
        }
    }

}
