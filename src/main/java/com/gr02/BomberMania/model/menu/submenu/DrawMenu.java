package com.gr02.BomberMania.model.menu.submenu;

import com.gr02.BomberMania.model.menu.Menu;

import java.util.Arrays;

public class DrawMenu extends Menu {

    String drawReason;

    public DrawMenu(String reason) {
        super(Arrays.asList("Replay", "Main Menu", "Exit"));
        drawReason = reason;
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

    public String getDrawReason() {
        return drawReason;
    }
}

