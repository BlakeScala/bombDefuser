package com.epicodus.blake.bombdefuser.ui;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.epicodus.blake.bombdefuser.R;
import com.epicodus.blake.bombdefuser.models.Switch;
import com.epicodus.blake.bombdefuser.models.SwitchLevel;

import java.util.Arrays;
import java.util.List;

public class SwitchOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        List<String> levelOneColors = Arrays.asList("blue", "red");
        Switch switchOne = new Switch(levelOneColors.get(0));
        Switch switchTwo = new Switch(levelOneColors.get(0));
        Switch switchThree = new Switch(levelOneColors.get(0));
        Switch switchFour = new Switch(levelOneColors.get(0));
        Switch switchFive = new Switch(levelOneColors.get(0));
        List<Switch> levelOneSwitches = Arrays.asList(switchOne, switchTwo, switchThree, switchFour, switchFive);

        SwitchLevel switchPuzzleOne = new SwitchLevel(1, levelOneSwitches);
    }
}
//in for loop, if >5, toggle i - 5