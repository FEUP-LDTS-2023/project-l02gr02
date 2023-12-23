package com.gr02.BomberMania.controller.menu.submenu;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class InstructionsMenuControllerTest {
    @Test
    void stepTest() throws IOException {
        InstructionsMenu instructionsMenu = Mockito.mock(InstructionsMenu.class);
        InstructionsMenuController controller = new InstructionsMenuController(instructionsMenu);

        Game game = Mockito.mock(Game.class);

        Mockito.when(instructionsMenu.isSelectedGoBack()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }
}
