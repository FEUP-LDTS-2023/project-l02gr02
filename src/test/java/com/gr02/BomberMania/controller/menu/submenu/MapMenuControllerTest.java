package com.gr02.BomberMania.controller.menu.submenu;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.states.game.GameState;
import com.gr02.BomberMania.states.menu.MainMenuState;
import com.gr02.BomberMania.states.menu.submenu.MapMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapMenuControllerTest {
    @Test
    void stepTest() throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException {
        MapMenu mapMenu = Mockito.mock(MapMenu.class);
        MapMenuController controller = new MapMenuController(mapMenu);

        Game game = Mockito.mock(Game.class);
        controller.step(game, GUI.ACTION.UP, 1);
        Mockito.verify(mapMenu, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.DOWN, 1);
        Mockito.verify(mapMenu, Mockito.times(1)).nextEntry();

        Mockito.when(mapMenu.isSelectedMap1()).thenReturn(true);
        Mockito.when(mapMenu.isSelectedMap2()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap3()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedRandomMap()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedGoBack()).thenReturn(false);
        List<State> states = new ArrayList<>();
        Mockito.doAnswer((i) -> {
            states.add((State) i.getArguments()[0]);
            return null;
        }).when(game).setState(Mockito.any(State.class));

        controller.step(game, GUI.ACTION.SELECT, 1);
        Arena createdArena = (Arena) states.get(0).getModel();
        assertEquals(15, createdArena.getWidth());
        assertEquals(13, createdArena.getHeight());

        Mockito.when(mapMenu.isSelectedMap1()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap2()).thenReturn(true);
        Mockito.when(mapMenu.isSelectedMap3()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedRandomMap()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedGoBack()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        createdArena = (Arena) states.get(1).getModel();
        assertEquals(15, createdArena.getWidth());
        assertEquals(9, createdArena.getHeight());

        Mockito.when(mapMenu.isSelectedMap1()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap2()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap3()).thenReturn(true);
        Mockito.when(mapMenu.isSelectedRandomMap()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedGoBack()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        createdArena = (Arena) states.get(2).getModel();
        assertEquals(20, createdArena.getWidth());
        assertEquals(20, createdArena.getHeight());

        Mockito.when(mapMenu.isSelectedMap1()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap2()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap3()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedRandomMap()).thenReturn(true);
        Mockito.when(mapMenu.isSelectedGoBack()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        createdArena = (Arena) states.get(3).getModel();
        boolean found = false;
        if ((20 == createdArena.getWidth() && 20 == createdArena.getHeight())
                || (15 == createdArena.getWidth() && 9 == createdArena.getHeight())
                || (15 == createdArena.getWidth() && 13 == createdArena.getHeight())) found = true;
        assertTrue(found);

        Mockito.when(mapMenu.isSelectedMap1()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap2()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedMap3()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedRandomMap()).thenReturn(false);
        Mockito.when(mapMenu.isSelectedGoBack()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 1);
        assertTrue(states.get(4).getModel() instanceof MainMenu);
    }
}
