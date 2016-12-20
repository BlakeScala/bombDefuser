package com.epicodus.blake.bombdefuser.models;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Blake on 12/19/16.
 */

public class Switch {
    private String currentColor;
    private int currentLevel;
    private int timesClicked = 0;


    public Switch(String currentColor){
        this.currentColor = currentColor;
    }

    public void setCurrentColor(String color) {
        this.currentColor = color;
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public int getTimesClicked() {
        return this.timesClicked;
    }


}
