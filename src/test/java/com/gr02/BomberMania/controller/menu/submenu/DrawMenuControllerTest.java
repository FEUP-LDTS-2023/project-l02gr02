package com.gr02.BomberMania.controller.menu.submenu;

import com.gr02.BomberMania.Game;

import com.gr02.BomberMania.gui.GUI;

import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;
import com.gr02.BomberMania.states.menu.submenu.MapMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class DrawMenuControllerTest {
    @Test
    void stepTest() throws IOException {
        DrawMenu drawMenu = Mockito.mock(DrawMenu.class);
        DrawMenuController controller = new DrawMenuController(drawMenu);

        Game game = Mockito.mock(Game.class);
        controller.step(game, GUI.ACTION.UP, 1);
        Mockito.verify(drawMenu, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.DOWN, 1);
        Mockito.verify(drawMenu, Mockito.times(1)).nextEntry();

        Mockito.when(drawMenu.isSelectedReplay()).thenReturn(true);
        Mockito.when(drawMenu.isSelectedMainMenu()).thenReturn(false);
        Mockito.when(drawMenu.isSelectedExit()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(any(MainMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(null);

        Mockito.when(drawMenu.isSelectedReplay()).thenReturn(false);
        Mockito.when(drawMenu.isSelectedMainMenu()).thenReturn(true);
        Mockito.when(drawMenu.isSelectedExit()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(null);

        Mockito.when(drawMenu.isSelectedReplay()).thenReturn(false);
        Mockito.when(drawMenu.isSelectedMainMenu()).thenReturn(false);
        Mockito.when(drawMenu.isSelectedExit()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
}
