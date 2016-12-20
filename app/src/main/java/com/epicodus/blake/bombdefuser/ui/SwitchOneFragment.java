package com.epicodus.blake.bombdefuser.ui;


import android.content.pm.ActivityInfo;
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

    public void onClick(View v) {
        if (v == blockOne) {

        }
        if (v == blockTwo) {

        }
        if (v == blockThree) {

        }
        if (v == blockFour) {

        }
        if (v == blockFive) {

        }
    }

}
