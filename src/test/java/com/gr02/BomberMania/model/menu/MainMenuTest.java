package com.gr02.BomberMania.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuTest {
    @Test
    void selectOptionTest() {
        MainMenu menu = new MainMenu();
        assertEquals(true, menu.isSelectedStart());
        assertEquals(false, menu.isSelectedInstruction());
        assertEquals(false, menu.isSelectedMuteMusic());
        assertEquals(false, menu.isSelectedExit());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedStart());
        assertEquals(true, menu.isSelectedInstruction());
        assertEquals(false, menu.isSelectedMuteMusic());
        assertEquals(false, menu.isSelectedExit());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedStart());
        assertEquals(false, menu.isSelectedInstruction());
        assertEquals(true, menu.isSelectedMuteMusic());
        assertEquals(false, menu.isSelectedExit());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedStart());
        assertEquals(false, menu.isSelectedInstruction());
        assertEquals(false, menu.isSelectedMuteMusic());
        assertEquals(true, menu.isSelectedExit());
        menu.nextEntry();
        assertEquals(true, menu.isSelectedStart());
        assertEquals(false, menu.isSelectedInstruction());
        assertEquals(false, menu.isSelectedMuteMusic());
        assertEquals(false, menu.isSelectedExit());
    }
}
