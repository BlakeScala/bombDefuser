package com.epicodus.blake.bombdefuser.ui;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.blake.bombdefuser.R;
import com.epicodus.blake.bombdefuser.models.Switch;
import com.epicodus.blake.bombdefuser.models.SwitchLevel;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchOneFragment extends Fragment {
    List<String> levelOneColors = Arrays.asList("blue", "red");

    public SwitchOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Switch switchOne = new Switch(levelOneColors.get(0));
        Switch switchTwo = new Switch(levelOneColors.get(0));
        Switch switchThree = new Switch(levelOneColors.get(0));
        Switch switchFour = new Switch(levelOneColors.get(0));
        Switch switchFive = new Switch(levelOneColors.get(0));
        List<Switch> levelOneSwitches = Arrays.asList(switchOne, switchTwo, switchThree, switchFour, switchFive);

        SwitchLevel switchPuzzleOne = new SwitchLevel(1, levelOneSwitches);

        return inflater.inflate(R.layout.fragment_switch_one, container, false);
    }



}
