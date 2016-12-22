package com.epicodus.blake.bombdefuser.ui;


import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.epicodus.blake.bombdefuser.R;
import com.epicodus.blake.bombdefuser.models.Switch;
import com.epicodus.blake.bombdefuser.models.SwitchLevel;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchOneFragment extends Fragment implements View.OnClickListener {
    List<String> levelOneColors = Arrays.asList("blue", "red");
    List<ImageView> levelOneBlocks;
    @Bind(R.id.switchOne) ImageView blockOne;
    @Bind(R.id.switchTwo) ImageView blockTwo;
    @Bind(R.id.switchThree) ImageView blockThree;
    @Bind(R.id.switchFour) ImageView blockFour;
    @Bind(R.id.switchFive) ImageView blockFive;

    Switch switchOne = new Switch(0, levelOneColors.get(1));
    Switch switchTwo = new Switch(1, levelOneColors.get(0));
    Switch switchThree = new Switch(2, levelOneColors.get(1));
    Switch switchFour = new Switch(3, levelOneColors.get(1));
    Switch switchFive = new Switch(4, levelOneColors.get(0));

    private int totalClicks = 0;
    private int levelCombo = 0;

    List<Switch> levelOneSwitches = Arrays.asList(switchOne, switchTwo, switchThree, switchFour, switchFive);


    public SwitchOneFragment() {
        // Required empty public constructor
    }

    public int getLevel() {
        return 1;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public String getLevelCombo() {
        String stringLevelCombo = String.format("%02d", this.levelCombo);
        return stringLevelCombo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_switch_one, container, false);

        ButterKnife.bind(this, view);

        levelOneBlocks = Arrays.asList(blockOne, blockTwo, blockThree, blockFour, blockFive);

        blockOne.setOnClickListener(this);
        blockTwo.setOnClickListener(this);
        blockThree.setOnClickListener(this);
        blockFour.setOnClickListener(this);
        blockFive.setOnClickListener(this);

        bindColors(switchOne ,blockOne);
        bindColors(switchTwo, blockTwo);
        bindColors(switchThree, blockThree);
        bindColors(switchFour, blockFour);
        bindColors(switchFive, blockFive);

        generateLevel();

        while (hasTooManyBlues()) {
            generateLevel();
        }

        return view;
    }

    public void onClick(View v) {
        addClicks();
        if (v == blockOne) {
            clickSwitch(switchOne);
        }
        if (v == blockTwo) {
            clickSwitch(switchTwo);
        }
        if (v == blockThree) {
            clickSwitch(switchThree);
        }
        if (v == blockFour) {
            clickSwitch(switchFour);
        }
        if (v == blockFive) {
            clickSwitch(switchFive);
        }
    }

    public boolean hasTooManyBlues() {
        int counter = 0;
        for (int i = 0; i < levelOneSwitches.size(); i++) {
            if (levelOneSwitches.get(i).getCurrentColor().equals("blue")) {
                counter++;
            }
        }
        if (counter > 2) {
            return true;
        } else {
            return false;
        }
    }

    public void generateLevel() {
        int numberToSwitch = 200;
        for (int i = 0; i < numberToSwitch; i++) {
            int randomNumber = randomWithRange(0, 4);
            toggleSwitch(levelOneSwitches.get(randomNumber), levelOneBlocks.get(randomNumber));
        }
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public void clickSwitch(Switch clickedSwitch) {

        Switch switchOne = this.levelOneSwitches.get(0);
        Switch switchTwo = this.levelOneSwitches.get(1);
        Switch switchThree = this.levelOneSwitches.get(2);
        Switch switchFour = this.levelOneSwitches.get(3);
        Switch switchFive = this.levelOneSwitches.get(4);

        if (this.getLevel() == 1) {
            if (clickedSwitch == switchOne) {
                toggleSwitch(switchThree, blockThree);
                toggleSwitch(switchFour, blockFour);
            } else if (clickedSwitch == switchTwo) {
                toggleSwitch(switchOne, blockOne);
                toggleSwitch(switchThree, blockThree);
            } else if (clickedSwitch == switchThree) {
                toggleSwitch(switchFive, blockFive);
            } else if (clickedSwitch == switchFour) {
                toggleSwitch(switchOne, blockOne);
                toggleSwitch(switchTwo, blockTwo);
            } else if (clickedSwitch == switchFive) {
                toggleSwitch(switchTwo, blockTwo);
            }
        } else if (this.getLevel() == 2) {

        } else if (this.getLevel() == 3) {

        }
    }

    public void toggleSwitch(Switch clickedSwitch, ImageView block) {
        if (clickedSwitch.getCurrentColor().equals("blue")) {
            clickedSwitch.setCurrentColor("red");
            bindColors(clickedSwitch, block);
        } else if (clickedSwitch.getCurrentColor().equals("red")) {
            clickedSwitch.setCurrentColor("blue");
            bindColors(clickedSwitch, block);
        }
    }

    public void bindColors(Switch clickedSwitch, ImageView block) {
        if (clickedSwitch.getCurrentColor().equals("blue")) {
            block.setBackgroundColor(Color.rgb(66, 134, 244));
        } else if (clickedSwitch.getCurrentColor().equals("red")) {
            block.setBackgroundColor(Color.rgb(175, 20, 3));
        }
    }

    public boolean puzzleIsCompleted() {
        boolean isCompleted = true;
        for (int i = 0; i < levelOneSwitches.size(); i++) {
            if (!(levelOneSwitches.get(i).getCurrentColor().equals("blue"))) {
                isCompleted = false;
            }
        }
        return isCompleted;
    }

    public void addClicks() {
        totalClicks++;
        if (levelCombo == 100) {
            levelCombo = 0;
        } else {
            levelCombo++;
        }

    }
}



