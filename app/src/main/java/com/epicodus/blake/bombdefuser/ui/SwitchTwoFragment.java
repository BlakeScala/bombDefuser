package com.epicodus.blake.bombdefuser.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.blake.bombdefuser.R;
import com.epicodus.blake.bombdefuser.models.Switch;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchTwoFragment extends Fragment implements View.OnClickListener {
    List<String> levelTwoColors = Arrays.asList("blue", "red", "purple");
    List<ImageView> levelTwoBlocks;

    @Bind(R.id.switchOne) ImageView blockOne;
    @Bind(R.id.switchTwo) ImageView blockTwo;
    @Bind(R.id.switchThree) ImageView blockThree;
    @Bind(R.id.switchFour) ImageView blockFour;
    @Bind(R.id.switchFive) ImageView blockFive;

    Switch switchOne = new Switch(0, levelTwoColors.get(2));
    Switch switchTwo = new Switch(1, levelTwoColors.get(1));
    Switch switchThree = new Switch(2, levelTwoColors.get(1));
    Switch switchFour = new Switch(3, levelTwoColors.get(2));
    Switch switchFive = new Switch(4, levelTwoColors.get(0));

    private int totalClicks = 0;
    private int levelCombo = 0;

    List<Switch> levelTwoSwitches = Arrays.asList(switchOne, switchTwo, switchThree, switchFour, switchFive);


    public SwitchTwoFragment() {
        // Required empty public constructor
    }

    public int getLevel() {
        return 2;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public int getLevelCombo() {
        return levelCombo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_switch_two, container, false);

        ButterKnife.bind(this, view);

        levelTwoBlocks = Arrays.asList(blockOne, blockTwo, blockThree, blockFour, blockFive);

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
        if (puzzleIsCompleted()) {
            Toast.makeText(getActivity(), "DONE with " + totalClicks + " clicks!" , Toast.LENGTH_SHORT).show();
        }
    }

    public boolean hasTooManyBlues() {
        int counter = 0;
        for (int i = 0; i < levelTwoSwitches.size(); i++) {
            if (levelTwoSwitches.get(i).getCurrentColor().equals("blue")) {
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
            toggleSwitch(levelTwoSwitches.get(randomNumber), levelTwoBlocks.get(randomNumber));
        }
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public void clickSwitch(Switch clickedSwitch) {

        Switch switchOne = this.levelTwoSwitches.get(0);
        Switch switchTwo = this.levelTwoSwitches.get(1);
        Switch switchThree = this.levelTwoSwitches.get(2);
        Switch switchFour = this.levelTwoSwitches.get(3);
        Switch switchFive = this.levelTwoSwitches.get(4);


        if (clickedSwitch == switchOne) {
            toggleSwitch(switchOne, blockOne);
        } else if (clickedSwitch == switchTwo) {
            toggleSwitch(switchTwo, blockTwo);
        } else if (clickedSwitch == switchThree) {
            toggleSwitch(switchThree, blockThree);
        } else if (clickedSwitch == switchFour) {
            toggleSwitch(switchFour, blockFour);
        } else if (clickedSwitch == switchFive) {
            toggleSwitch(switchFive, blockFive);
        }
    }

    public void toggleSwitch(Switch clickedSwitch, ImageView block) {
//        for (int i = 0; i < levelTwoColors.size(); i++) {
//            if (clickedSwitch.getCurrentColor().equals(levelTwoColors.get(i))) {
//                if (i < 2) {
//                    clickedSwitch.setCurrentColor(levelTwoColors.get(i + 1));
//                    bindColors(clickedSwitch, block);
//                } else if (i == 2) {
//                    clickedSwitch.setCurrentColor(levelTwoColors.get(0));
//                    bindColors(clickedSwitch, block);
//                }
//            }
//        }
        if (clickedSwitch.getCurrentColor().equals("blue")) {
            clickedSwitch.setCurrentColor("red");
            bindColors(clickedSwitch, block);
        } else if (clickedSwitch.getCurrentColor().equals("red")) {
            clickedSwitch.setCurrentColor("purple");
            bindColors(clickedSwitch, block);
        } else if (clickedSwitch.getCurrentColor().equals("purple")) {
            clickedSwitch.setCurrentColor("blue");
            bindColors(clickedSwitch, block);
        }
    }

    public void bindColors(Switch clickedSwitch, ImageView block) {
        if (clickedSwitch.getCurrentColor().equals("blue")) {
            block.setBackgroundColor(Color.rgb(66, 134, 244));
        } else if (clickedSwitch.getCurrentColor().equals("red")) {
            block.setBackgroundColor(Color.rgb(175, 20, 3));
        } else if (clickedSwitch.getCurrentColor().equals("purple")) {
            block.setBackgroundColor(Color.rgb(100, 0, 168));
        }
    }

    public boolean puzzleIsCompleted() {
        boolean isCompleted = true;
        for (int i = 0; i < levelTwoSwitches.size(); i++) {
            if (!(levelTwoSwitches.get(i).getCurrentColor().equals("blue"))) {
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


