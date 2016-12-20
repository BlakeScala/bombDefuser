package com.epicodus.blake.bombdefuser.ui;


import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    @Bind(R.id.switchOne) ImageView blockOne;
    @Bind(R.id.switchTwo) ImageView blockTwo;
    @Bind(R.id.switchThree) ImageView blockThree;
    @Bind(R.id.switchFour) ImageView blockFour;
    @Bind(R.id.switchFive) ImageView blockFive;

    Switch switchOne = new Switch(0, levelOneColors.get(0));
    Switch switchTwo = new Switch(1, levelOneColors.get(0));
    Switch switchThree = new Switch(2, levelOneColors.get(0));
    Switch switchFour = new Switch(3, levelOneColors.get(0));
    Switch switchFive = new Switch(4, levelOneColors.get(0));

    List<Switch> levelOneSwitches = Arrays.asList(switchOne, switchTwo, switchThree, switchFour, switchFive);
    List<ImageView> levelOneBlocks = Arrays.asList(blockOne, blockTwo, blockThree, blockFour, blockFive);

    SwitchLevel switchPuzzleOne = new SwitchLevel(1, levelOneSwitches);

    public SwitchOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_switch_one, container, false);

        ButterKnife.bind(this, view);

        blockOne.setOnClickListener(this);
        blockTwo.setOnClickListener(this);
        blockThree.setOnClickListener(this);
        blockFour.setOnClickListener(this);
        blockFive.setOnClickListener(this);


        return view;
    }

    public void onClick(View v) {
        if (v == blockOne) {
            switchPuzzleOne.clickSwitch(switchOne.getIndex());
            changeBlockColors();
        }
        if (v == blockTwo) {
            switchPuzzleOne.clickSwitch(switchTwo.getIndex());
            changeBlockColors();
        }
        if (v == blockThree) {
            switchPuzzleOne.clickSwitch(switchThree.getIndex());
            changeBlockColors();
        }
        if (v == blockFour) {
            switchPuzzleOne.clickSwitch(switchFour.getIndex());
            changeBlockColors();
        }
        if (v == blockFive) {
            switchPuzzleOne.clickSwitch(switchFive.getIndex());
            changeBlockColors();
        }
    }

    public void changeBlockColors(ImageView block) {
        for (int i = 0; i < levelOneSwitches.size(); i++) {
            if (levelOneSwitches.get(i).getCurrentColor().equals("blue")) {
                block.setBackgroundColor(Color.rgb(66, 134, 244));
            } else if (levelOneSwitches.get(i).getCurrentColor().equals("red")) {
                block.setBackgroundColor(Color.rgb(244, 98, 66));
            }
        }
    }
}



