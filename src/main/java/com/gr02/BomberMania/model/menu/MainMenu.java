package com.gr02.BomberMania.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {

    public MainMenu() {
        super(Arrays.asList("Start", "Exit", "Instruction"));
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstruction() {
        return isSelected(2);
    }
}
