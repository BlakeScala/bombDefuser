package com.epicodus.blake.bombdefuser.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.blake.bombdefuser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WinnerActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.menuButton) Button mMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ButterKnife.bind(this);
        mMenuButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == mMenuButton) {
            Intent intent = new Intent(WinnerActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
