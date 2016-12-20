package com.epicodus.blake.bombdefuser.ui;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.epicodus.blake.bombdefuser.R;

import java.util.Arrays;
import java.util.List;

public class SwitchOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        List<Boolean> switches = Arrays.asList(false, false, false, false, false);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i <5; i++) {
            if (switches.get(i) == false) {
                Button button = new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                button.setBackgroundColor(Color.parseColor("#b20000"));
            } else if (switches.get(i) == true) {
                Button button = new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                button.setBackgroundColor(Color.parseColor("#037700"));
            }
        }
    }
}
//in for loop, if >5, toggle i - 5