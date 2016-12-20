package com.epicodus.blake.bombdefuser.models;

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
    private List<String> levelOneColors = Arrays.asList("blue", "red");
    private List<String> levelTwoColors = Arrays.asList("blue", "red", "purple");
    private List<String> levelThreeColors = Arrays.asList("blue", "red", "purple", "grey");

    public Switch(String currentColor, int currentLevel){
        this.currentColor = currentColor;
        this.currentLevel = currentLevel;
    }

    public List<String> getColorOptions() {
        if (this.getCurrentLevel() == 1) {
            return levelOneColors;
        } else if (this.getCurrentLevel() == 2) {
            return levelTwoColors;
        } else if (this.getCurrentLevel() == 3) {
            return levelThreeColors;
        }
    }

    public String toggle() {
        if (this.currentLevel == 1) {

        }
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public int getTimesClicked() {
        return this.timesClicked;
    }


}
