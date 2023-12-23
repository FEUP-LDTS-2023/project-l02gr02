package com.gr02.BomberMania.model.menu.submenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuTest {
    @Test
    void selectInstructionsOptionsTest() {
        InstructionsMenu instructionMenu = new InstructionsMenu();
        assertEquals(true, instructionMenu.isSelectedGoBack());
        instructionMenu.nextEntry();
        assertEquals(true, instructionMenu.isSelectedGoBack());
    }
}
