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

    public void clickSwitch(int switchIndex) {

        Switch switchOne = this.getSwitches().get(0);
        Switch switchTwo = this.getSwitches().get(1);
        Switch switchThree = this.getSwitches().get(2);
        Switch switchFour = this.getSwitches().get(3);
        Switch switchFive = this.getSwitches().get(4);

        if (this.getLevel() == 1) {
            if (switchIndex == 0) {
                toggleColor(switchOne);
            } else if (switchIndex == 1) {
                toggleColor(switchTwo);
            } else if (switchIndex == 2) {
                toggleColor(switchThree);
            } else if (switchIndex == 3) {
                toggleColor(switchFour);
            } else if (switchIndex == 4) {
                toggleColor(switchFive);
            }
        } else if (this.getLevel() == 2) {

        } else if (this.getLevel() == 3) {

        }
    }

    public void toggleColor(Switch thisSwitch) {
        if (thisSwitch.getCurrentColor().equals("blue")) {
            thisSwitch.setCurrentColor("red");
        } else if (thisSwitch.getCurrentColor().equals("red")) {
            thisSwitch.setCurrentColor("blue");
        }
    }
}
