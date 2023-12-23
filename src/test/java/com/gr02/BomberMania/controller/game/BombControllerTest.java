package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombControllerTest {
    @Test
    void stepTest() throws IOException {
        Game game = Mockito.mock(Game.class);
        Arena arena = new Arena(10, 10);
        PlayableCharacter character = Mockito.mock(PlayableCharacter.class);
        Bomb bomb1 = new Bomb(0, 0, new BombInfo(3, 1, character));
        List<Bomb> bombs = new ArrayList<Bomb>();
        bombs.add(bomb1);
        arena.setBombs(bombs);
        assertEquals(3, bomb1.getBombInfo().getTimer());
        assertEquals(1, arena.getBombs().size());

        BombController controller = new BombController(arena);
        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(2, bomb1.getBombInfo().getTimer());

        Bomb bomb2 = new Bomb(5, 5, new BombInfo(1, 1, character));
        arena.addBomb(bomb2);
        assertEquals(2, arena.getBombs().size());

        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(1, bomb1.getBombInfo().getTimer());
        assertEquals(0, bomb2.getBombInfo().getTimer());
        assertEquals(1, arena.getBombs().size());
        assertEquals(bomb1, arena.getBombs().get(0));

        controller.step(game, GUI.ACTION.NONE, 1);
        assertEquals(0, bomb1.getBombInfo().getTimer());
        assertEquals(0, bomb2.getBombInfo().getTimer());
        assertEquals(0, arena.getBombs().size());
    }
}
