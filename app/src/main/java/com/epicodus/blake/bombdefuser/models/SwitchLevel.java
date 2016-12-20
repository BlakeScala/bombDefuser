package com.epicodus.blake.bombdefuser.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Guest on 12/19/16.
 */
public class SwitchLevel {
    private int level;
    List<Switch> switches;
    List<String> colorArray;
    private List<String> levelOneColors = Arrays.asList("blue", "red");
    private List<String> levelTwoColors = Arrays.asList("blue", "red", "purple");
    private List<String> levelThreeColors = Arrays.asList("blue", "red", "purple", "grey");


    public SwitchLevel(int level, List<Switch> switches) {
        this.level = level;
        this.switches = switches;
    }

    public int getLevel() {
        return level;
    }

    public List<Switch> getSwitches() {
        return switches;
    }

    public List<String> getColorOptions() {
        if (this.getLevel() == 1) {
            this.colorArray = levelOneColors;

        } else if (this.getLevel() == 2) {
            this.colorArray = levelTwoColors;
        } else if (this.getLevel() == 3) {
            this.colorArray = levelThreeColors;
        }
        return this.colorArray;
    }


}
