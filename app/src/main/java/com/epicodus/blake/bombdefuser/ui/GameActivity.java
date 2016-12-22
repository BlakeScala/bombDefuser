package com.epicodus.blake.bombdefuser.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
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
import android.widget.Toast;

import com.epicodus.blake.bombdefuser.R;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.levelOneButton) Button mLevelOneButton;
    @Bind(R.id.levelTwoButton) Button mLevelTwoButton;
    @Bind(R.id.clockTimerView) TextView mClockTimerView;
    @Bind(R.id.levelThreeButton) Button mLevelThreeButton;
    @Bind(R.id.submitComboButton) Button mSubmitComboButton;
    @Bind(R.id.levelContainer) FrameLayout mLevelContainer;
    @Bind(R.id.combinationContainer) FrameLayout mCombinationContainer;
    @Bind(R.id.passWordDisplay) TextView mPasswordDisplay;

    CountDownTimer timer;

    SwitchOneFragment levelOne;
    SwitchTwoFragment levelTwo;
    SwitchThreeFragment levelThree;
    CombinationFragment finalLevel;

    int levelOneTotalClicks;
    int levelTwoTotalClicks;
    int levelThreeTotalClicks;
    int totalGameClicks = levelOneTotalClicks + levelTwoTotalClicks + levelThreeTotalClicks;
    long timeLeftonClock;

    String levelOneCombo;
    String levelTwoCombo;
    String levelThreeCombo;
    String finalCombination;
    String combinationEntry;

    boolean levelOneStarted = false;
    boolean levelTwoStarted = false;
    boolean levelThreeStarted = false;
    boolean showPassword = false;


    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ButterKnife.bind(this);
        finalLevel = new CombinationFragment();
        mLevelOneButton.setOnClickListener(this);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.combinationContainer, finalLevel).commit();

        mLevelOneButton.setText("1");


        timer = new CountDownTimer(420000, 100) {
            @Override
            public void onTick(long timeLeft) {
                long millis = timeLeft;
                timeLeftonClock = millis;
                String hms = String.format("%02d:%02d",
                        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis) - java.util.concurrent.TimeUnit.HOURS.toMinutes(java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millis)),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millis) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis))
                );
                String timeLeftString = String.valueOf((timeLeft/100));
                mClockTimerView.setText(hms);

                if (levelOneStarted) {
                    if (levelOneDone()) {
                        getSupportFragmentManager().beginTransaction().remove(levelOne).commit();
                        mLevelTwoButton.setText("2");
                        levelOneStarted = false;
                    }
                }
                if (levelTwoStarted) {
                    if (levelTwoDone()) {
                        getSupportFragmentManager().beginTransaction().remove(levelTwo).commit();
                        mLevelThreeButton.setText("3");
                        levelTwoStarted = false;
                    }
                }
                if (levelThreeStarted) {
                    if (levelThreeDone()) {
                        getSupportFragmentManager().beginTransaction().remove(levelThree).commit();
                        finalLevel.setOnClickListeners();
                        finalLevel.mCombinationTextView.setHint("XX XX XX");
                        levelThreeStarted = false;
                        startFinalLevel();
                    }
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(GameActivity.this, LoseGameActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
    }

    public void onClick(View v) {
        if (v == mLevelOneButton) {
            if (showPassword == true) {
                mPasswordDisplay.setText(levelOneCombo);
            } else {
                levelOneStarted = true;
                levelOne = new SwitchOneFragment();

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.levelContainer, levelOne);
                transaction.commit();
            }
        }
        if (v == mLevelTwoButton) {
            if (showPassword == true) {
                mPasswordDisplay.setText(levelTwoCombo);
            } else {
                levelTwoStarted = true;
                levelTwo = new SwitchTwoFragment();

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.levelContainer, levelTwo);
                transaction.commit();
            }
        }
        if (v == mLevelThreeButton) {
            if (showPassword == true) {
                mPasswordDisplay.setText(levelThreeCombo);
            } else {
                levelThreeStarted = true;
                levelThree = new SwitchThreeFragment();

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.levelContainer, levelThree);
                transaction.commit();
            }
        }
        if (v == mSubmitComboButton) {
            if (combinationsMatch()) {
                Intent intent = new Intent(GameActivity.this, WinnerActivity.class);
                startActivity(intent);
                finish();
            } else {
                if (!(combinationEntry.equals(""))){
                    Intent intent = new Intent(GameActivity.this, LoseGameActivity.class);
                    timer.cancel();
                    timer = null;
                    startActivity(intent);
                    finish();
                }
            }

        }
    }

    public boolean levelOneDone() {
        if(levelOne.puzzleIsCompleted()) {
            levelOneTotalClicks = levelOne.getTotalClicks();
            levelOneCombo = levelOne.getLevelCombo();
            mLevelOneButton.setOnClickListener(null);
            mLevelTwoButton.setOnClickListener(this);
            return true;
        } else {
            return false;
        }
    }


    public boolean levelTwoDone() {
        if (levelTwo.puzzleIsCompleted()) {
            levelTwoTotalClicks = levelTwo.getTotalClicks();
            levelTwoCombo = levelTwo.getLevelCombo();
            mLevelTwoButton.setOnClickListener(null);
            mLevelThreeButton.setOnClickListener(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean levelThreeDone() {
        if (levelThree.puzzleIsCompleted()) {
            levelThreeTotalClicks = levelThree.getTotalClicks();
            levelThreeCombo = levelThree.getLevelCombo();
            mLevelThreeButton.setOnClickListener(null);
            return true;
        } else {
            return false;
        }
    }

    public void startFinalLevel() {
        mSubmitComboButton.setOnClickListener(this);
        mLevelOneButton.setOnClickListener(this);
        mLevelTwoButton.setOnClickListener(this);
        mLevelThreeButton.setOnClickListener(this);
        showPassword = true;
    }

    public boolean combinationsMatch() {
        finalCombination = levelOneCombo + levelTwoCombo + levelThreeCombo;
        combinationEntry = finalLevel.getCombinationInput();
        Log.v("TAG", "Combo: " + finalCombination);
        Log.v("TAG", "Combo Input: " + combinationEntry);
        if (finalCombination.equals(combinationEntry)) {
            return true;
        } else {
            return false;
        }
    }



}
