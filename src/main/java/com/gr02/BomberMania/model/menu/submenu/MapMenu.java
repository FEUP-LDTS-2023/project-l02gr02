package com.gr02.BomberMania.model.menu.submenu;

import com.gr02.BomberMania.model.menu.Menu;

import java.util.Arrays;

public class MapMenu extends Menu {
    public MapMenu() {
        super(Arrays.asList("Map 1", "Map 2", "Map 3", "Random Map"));
    }

    public boolean isSelectedMap1() { return isSelected(0); }
    public boolean isSelectedMap2() { return isSelected(1); }
    public boolean isSelectedMap3() { return isSelected(2); }
    public boolean isSelectedRandomMap() { return isSelected(3); }
}
