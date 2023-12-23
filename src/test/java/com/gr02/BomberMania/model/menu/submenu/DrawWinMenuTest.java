package com.gr02.BomberMania.model.menu.submenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawWinMenuTest {
    @Test
    void selectDrawOptionsTest() {
        DrawMenu drawMenu = new DrawMenu("Reason");
        assertEquals(true, drawMenu.isSelectedReplay());
        assertEquals(false, drawMenu.isSelectedMainMenu());
        assertEquals(false, drawMenu.isSelectedExit());
        drawMenu.nextEntry();
        assertEquals(false, drawMenu.isSelectedReplay());
        assertEquals(true, drawMenu.isSelectedMainMenu());
        assertEquals(false, drawMenu.isSelectedExit());
        drawMenu.nextEntry();
        assertEquals(false, drawMenu.isSelectedReplay());
        assertEquals(false, drawMenu.isSelectedMainMenu());
        assertEquals(true, drawMenu.isSelectedExit());
        drawMenu.nextEntry();
        assertEquals(true, drawMenu.isSelectedReplay());
        assertEquals(false, drawMenu.isSelectedMainMenu());
        assertEquals(false, drawMenu.isSelectedExit());
    }

    @Test
    void selectWinOptionsTest() {
        WinMenu winMenu = new WinMenu(1);
        assertEquals(true, winMenu.isSelectedReplay());
        assertEquals(false, winMenu.isSelectedMainMenu());
        assertEquals(false, winMenu.isSelectedExit());
        winMenu.nextEntry();
        assertEquals(false, winMenu.isSelectedReplay());
        assertEquals(true, winMenu.isSelectedMainMenu());
        assertEquals(false, winMenu.isSelectedExit());
        winMenu.nextEntry();
        assertEquals(false, winMenu.isSelectedReplay());
        assertEquals(false, winMenu.isSelectedMainMenu());
        assertEquals(true, winMenu.isSelectedExit());
        winMenu.nextEntry();
        assertEquals(true, winMenu.isSelectedReplay());
        assertEquals(false, winMenu.isSelectedMainMenu());
        assertEquals(false, winMenu.isSelectedExit());
    }
}
