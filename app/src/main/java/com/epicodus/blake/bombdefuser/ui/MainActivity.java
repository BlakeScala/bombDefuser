package com.epicodus.blake.bombdefuser.ui;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.blake.bombdefuser.R;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.startButton) Button mStartButton;
    @Bind(R.id.logOutButton) Button mLogOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void onClick(View v) {
        if (v == mStartButton) {
            startGame();
        }
        if (v == mLogOutButton) {

        }
    }

    public void startGame() {}

}
