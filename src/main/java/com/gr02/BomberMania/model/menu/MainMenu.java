package com.gr02.BomberMania.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {

    public MainMenu() {
        super(Arrays.asList("Start", "Instructions", "Exit", "Mute Music"));
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstruction() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedMuteMusic() {
        return isSelected(3);
    }

}
