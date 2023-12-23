package com.gr02.BomberMania.controller.menu;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.music.Sound;
import com.gr02.BomberMania.states.menu.submenu.InstructionsMenuState;
import com.gr02.BomberMania.states.menu.submenu.MapMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class MainMenuControllerTest {
    @Test
    void stepTest() throws IOException {
        MainMenu mainMenu = Mockito.mock(MainMenu.class);
        MainMenuController controller = new MainMenuController(mainMenu);

        Game game = Mockito.mock(Game.class);
        controller.step(game, GUI.ACTION.UP, 1);
        Mockito.verify(mainMenu, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.DOWN, 1);
        Mockito.verify(mainMenu, Mockito.times(1)).nextEntry();

        Sound music = Mockito.mock(Sound.class);
        Mockito.doAnswer((i) -> music).when(game).getMusic();

        Mockito.when(mainMenu.isSelectedExit()).thenReturn(true);
        Mockito.when(mainMenu.isSelectedStart()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedInstruction()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedMuteMusic()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(null);
        Mockito.verify(game, Mockito.times(0)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(any(InstructionsMenuState.class));
        Mockito.verify(music, Mockito.times(0)).volumeSoundMute();

        Mockito.when(mainMenu.isSelectedExit()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedStart()).thenReturn(true);
        Mockito.when(mainMenu.isSelectedInstruction()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedMuteMusic()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(null);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(any(InstructionsMenuState.class));
        Mockito.verify(music, Mockito.times(0)).volumeSoundMute();

        Mockito.when(mainMenu.isSelectedExit()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedStart()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedInstruction()).thenReturn(true);
        Mockito.when(mainMenu.isSelectedMuteMusic()).thenReturn(false);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(null);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(any(InstructionsMenuState.class));
        Mockito.verify(music, Mockito.times(0)).volumeSoundMute();

        Mockito.when(mainMenu.isSelectedExit()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedStart()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedInstruction()).thenReturn(false);
        Mockito.when(mainMenu.isSelectedMuteMusic()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(null);
        Mockito.verify(game, Mockito.times(1)).setState(any(MapMenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(any(InstructionsMenuState.class));
        Mockito.verify(music, Mockito.times(1)).volumeSoundMute();
    }
}
