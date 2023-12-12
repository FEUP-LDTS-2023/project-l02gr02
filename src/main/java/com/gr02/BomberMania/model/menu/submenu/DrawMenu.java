package com.gr02.BomberMania.model.menu.submenu;

import com.gr02.BomberMania.model.menu.Menu;

import java.util.Arrays;

public class DrawMenu extends Menu {

    public DrawMenu() {
        super(Arrays.asList("Replay", "Main Menu", "Exit"));
    }

    public boolean isSelectedReplay() {
        return isSelected(0);
    }

    public boolean isSelectedMainMenu() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}

