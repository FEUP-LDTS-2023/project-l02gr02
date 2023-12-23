package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.Flame;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.states.State;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlameControllerTest {
    @Test
    void stepTest() throws IOException {
        Game game = Mockito.mock(Game.class);
        Arena arena = new Arena(10, 10);
        PlayableCharacter character1 = new PlayableCharacter(1, 1, new BombInfo(), 1);
        PlayableCharacter character2 = new PlayableCharacter(2, 2, new BombInfo(), 2);
        arena.setPlayer1(character1);
        arena.setPlayer2(character2);
        Flame flame1 = new Flame(0, 0);
        List<Flame> flames = new ArrayList<Flame>();
        flames.add(flame1);
        arena.setFlames(flames);
        assertEquals(60, flame1.getTimer());
        assertEquals(1, arena.getFlames().size());

        FlameController controller = new FlameController(arena);
        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(59, flame1.getTimer());

        for (int i = 0; i < 58; i++) {
            controller.step(game, GUI.ACTION.NONE, 1);
        }

        Flame flame2 = new Flame(5, 5);
        arena.addFlame(flame2);
        assertEquals(2, arena.getFlames().size());

        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(0, flame1.getTimer());
        assertEquals(59, flame2.getTimer());
        assertEquals(1, arena.getFlames().size());
        assertEquals(flame2, arena.getFlames().get(0));

        for (int i = 0; i < 58; i++) {
            controller.step(game, GUI.ACTION.NONE, 1);
        }

        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(0, flame1.getTimer());
        assertEquals(0, flame2.getTimer());
        assertEquals(0, arena.getFlames().size());

        List<State> states = new ArrayList<>();
        Mockito.doAnswer((i) -> {
            states.add((State) i.getArguments()[0]);
            return null;
        }).when(game).setState(Mockito.any(State.class));

        Flame flame3 = new Flame(1, 1);
        arena.addFlame(flame3);
        controller.step(game, GUI.ACTION.NONE, 1);
        WinMenu winMenu = (WinMenu) states.get(0).getModel();
        assertEquals(2, winMenu.getPlayerNumber());

        arena.getFlames().clear();
        Flame flame4 = new Flame(2, 2);
        arena.addFlame(flame4);
        controller.step(game, GUI.ACTION.NONE, 1);
        winMenu = (WinMenu) states.get(1).getModel();
        assertEquals(1, winMenu.getPlayerNumber());

        arena.getFlames().clear();
        arena.addFlame(flame3);
        arena.addFlame(flame4);
        controller.step(game, GUI.ACTION.NONE, 1);
        DrawMenu drawMenu = (DrawMenu) states.get(2).getModel();
        assertEquals("BOTH DIED!!", drawMenu.getDrawReason());
    }
}
