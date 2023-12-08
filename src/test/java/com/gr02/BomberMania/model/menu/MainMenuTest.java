package com.gr02.BomberMania.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class MainMenuTest {

    @Test
    public void nextEntry() {
        MainMenu menu = new MainMenu();
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
        MainMenu menu = new MainMenu();
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


