package com.gr02.BomberMania.model.menu;

import java.util.Arrays;

public class WinMenu extends Menu{

    final int playerNumber;

    public WinMenu(int playerNumber) {
        super(Arrays.asList("Replay", "Main Menu", "Exit"));
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
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
