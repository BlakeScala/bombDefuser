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
    private int index;
    private int timesClicked = 0;

    public Switch(int index, String currentColor){
        this.index = index;
        this.currentColor = currentColor;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String color) {
        this.currentColor = color;
    }

    public int getTimesClicked() {
        return this.timesClicked;
    }

    public int getIndex() {
        return index;
    }

}
