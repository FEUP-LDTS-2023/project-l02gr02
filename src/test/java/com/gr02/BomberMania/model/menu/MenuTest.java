package com.gr02.BomberMania.model.menu;

import com.gr02.BomberMania.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuTest {

    private List<String> entries = Arrays.asList("Start", "Exit", "Instruction");

    @Test
    public void nextEntry() {
        Menu menu = new Menu(entries);
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
        Menu menu = new Menu(entries);
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


