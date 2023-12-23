package com.gr02.BomberMania.model.menu.submenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapMenuTest {
    @Test
    void selectOptionTest() {
        MapMenu menu = new MapMenu();
        assertEquals(true, menu.isSelectedMap1());
        assertEquals(false, menu.isSelectedMap2());
        assertEquals(false, menu.isSelectedMap3());
        assertEquals(false, menu.isSelectedRandomMap());
        assertEquals(false, menu.isSelectedGoBack());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedMap1());
        assertEquals(true, menu.isSelectedMap2());
        assertEquals(false, menu.isSelectedMap3());
        assertEquals(false, menu.isSelectedRandomMap());
        assertEquals(false, menu.isSelectedGoBack());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedMap1());
        assertEquals(false, menu.isSelectedMap2());
        assertEquals(true, menu.isSelectedMap3());
        assertEquals(false, menu.isSelectedRandomMap());
        assertEquals(false, menu.isSelectedGoBack());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedMap1());
        assertEquals(false, menu.isSelectedMap2());
        assertEquals(false, menu.isSelectedMap3());
        assertEquals(true, menu.isSelectedRandomMap());
        assertEquals(false, menu.isSelectedGoBack());
        menu.nextEntry();
        assertEquals(false, menu.isSelectedMap1());
        assertEquals(false, menu.isSelectedMap2());
        assertEquals(false, menu.isSelectedMap3());
        assertEquals(false, menu.isSelectedRandomMap());
        assertEquals(true, menu.isSelectedGoBack());
        menu.nextEntry();
        assertEquals(true, menu.isSelectedMap1());
        assertEquals(false, menu.isSelectedMap2());
        assertEquals(false, menu.isSelectedMap3());
        assertEquals(false, menu.isSelectedRandomMap());
        assertEquals(false, menu.isSelectedGoBack());
    }
}
