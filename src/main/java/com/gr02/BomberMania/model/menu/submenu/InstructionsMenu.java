package com.gr02.BomberMania.model.menu.submenu;

import com.gr02.BomberMania.model.menu.Menu;

import java.util.Arrays;

public class InstructionsMenu extends Menu {
    public InstructionsMenu() {
        super(Arrays.asList("Go Back"));
    }

    public boolean isSelectedGoBack() {
        return isSelected(0);
    }

}
