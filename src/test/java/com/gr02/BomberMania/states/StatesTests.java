package com.gr02.BomberMania.states;

import com.gr02.BomberMania.controller.game.GameController;
import com.gr02.BomberMania.controller.menu.MainMenuController;
import com.gr02.BomberMania.controller.menu.submenu.*;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.*;
import com.gr02.BomberMania.states.game.GameState;
import com.gr02.BomberMania.states.menu.MainMenuState;
import com.gr02.BomberMania.states.menu.submenu.*;
import com.gr02.BomberMania.viewer.GameViewer;
import com.gr02.BomberMania.viewer.menu.MainMenuViewer;
import com.gr02.BomberMania.viewer.menu.submenu.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatesTests {
    Arena arena;
    GameState gameState;
    MainMenuState mainMenuState;
    MainMenu mainMenu;
    WinState winState;
    WinMenu winMenu;
    MapMenuState mapMenuState;
    MapMenu mapMenu;
    InstructionsMenuState instructionsMenuState;
    InstructionsMenu instructionsMenu;
    DrawState drawState;
    DrawMenu drawMenu;

    @Test
    public void GameStateTest() {
        arena = Mockito.mock(Arena.class);
        gameState = new GameState(arena);

        Assertions.assertTrue(gameState.getViewer() instanceof GameViewer);
        Assertions.assertTrue(gameState.getController() instanceof GameController);
    }

    @Test
    public void MainMenuStateTest() {
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuState = new MainMenuState(mainMenu);

        Assertions.assertTrue(mainMenuState.getViewer() instanceof MainMenuViewer);
        Assertions.assertTrue(mainMenuState.getController() instanceof MainMenuController);
    }

    @Test
    public void WinMenuStateTest() {
        winMenu = Mockito.mock(WinMenu.class);
        winState = new WinState(winMenu);

        Assertions.assertTrue(winState.getViewer() instanceof WinMenuViewer);
        Assertions.assertTrue(winState.getController() instanceof WinMenuController);
    }

    @Test
    public void MapMenuStateTest() {
        mapMenu = Mockito.mock(MapMenu.class);
        mapMenuState = new MapMenuState(mapMenu);

        Assertions.assertTrue(mapMenuState.getViewer() instanceof MapMenuViewer);
        Assertions.assertTrue(mapMenuState.getController() instanceof MapMenuController);
    }
    @Test
    public void InstructionsMenuStateTest() {
        instructionsMenu = Mockito.mock(InstructionsMenu.class);
        instructionsMenuState = new InstructionsMenuState(instructionsMenu);

        Assertions.assertTrue(instructionsMenuState.getViewer() instanceof InstructionsMenuViewer);
        Assertions.assertTrue(instructionsMenuState.getController() instanceof InstructionsMenuController);
    }
    @Test
    public void DrawStateTest() {
        drawMenu = Mockito.mock(DrawMenu.class);
        drawState = new DrawState(drawMenu);

        Assertions.assertTrue(drawState.getViewer() instanceof DrawMenuViewer);
        Assertions.assertTrue(drawState.getController() instanceof DrawMenuController);
    }
}
