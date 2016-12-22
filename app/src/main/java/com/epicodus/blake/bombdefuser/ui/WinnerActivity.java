package com.epicodus.blake.bombdefuser.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.blake.bombdefuser.Constants;
import com.epicodus.blake.bombdefuser.R;
import com.epicodus.blake.bombdefuser.models.HighScore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WinnerActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.menuButton) Button mMenuButton;
    private DatabaseReference mScoreReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ButterKnife.bind(this);
        mMenuButton.setOnClickListener(this);

//        Intent intent = getIntent();
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        String userName = user.getEmail();
//        HighScore leaderboardEntry = new HighScore(userName, timeLeft, totalClicks);
//
//        mScoreReference = FirebaseDatabase
//                .getInstance()
//                .getReference(Constants.FIREBASE_CHILD_SCORES)
//                .child(uid);
//
//        DatabaseReference pushRef = mScoreReference.push();
//        String pushId = pushRef.getKey();
//        leaderboardEntry.setPushId(pushId);
//        pushRef.setValue(leaderboardEntry);
    }

    public void onClick(View v) {
        if (v == mMenuButton) {
            Intent intent = new Intent(WinnerActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
