package com.epicodus.blake.bombdefuser.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Guest on 12/19/16.
 */
public class SwitchLevel {
    private int level;
    private boolean completed;
    List<Boolean> switches = Arrays.asList(false, false, false, false, false);
    private List<Boolean> onOrOff;


    public SwitchLevel(int level, boolean completed, ArrayList<Boolean> switches, List<Boolean> onOrOff) {
        this.level = level;
        this.completed = completed;
        this.switches = switches;
        this.onOrOff = onOrOff;
    }


    public List<Boolean> getOnOrOff() {
        return onOrOff;
    }

    public int getLevel() {
        return level;
    }

    public boolean isCompleted() {
        return completed;
    }

    public List<Boolean> getSwitches() {
        return switches;
    }

    public void generateSwitches(int numberOfSwitches) {

    }


}
