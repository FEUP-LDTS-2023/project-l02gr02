package com.gr02.BomberMania.model;

import com.gr02.BomberMania.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class menuTest {
    @Test
    public void nextEntry() {
        Menu menu = new Menu();
        Assertions.assertEquals(0, menu.getCurrentEntry());
        menu.nextEntry();
        Assertions.assertEquals(1, menu.getCurrentEntry());
        menu.nextEntry();
        Assertions.assertEquals(2, menu.getCurrentEntry());

        for (int k = 0; k < menu.getNumberEntries(); k++) {
            menu.nextEntry();
        }
        Assertions.assertEquals(2, menu.getCurrentEntry());
    }

    @Test
    public void previousEntry() {
        Menu menu = new Menu();
        Assertions.assertEquals(0, menu.getCurrentEntry());
        menu.previousEntry();
        Assertions.assertEquals(2, menu.getCurrentEntry());
        menu.previousEntry();
        Assertions.assertEquals(1, menu.getCurrentEntry());

        for (int k = 0; k < menu.getNumberEntries(); k++) {
            menu.previousEntry();
        }
        Assertions.assertEquals(1, menu.getCurrentEntry());
    }
}


