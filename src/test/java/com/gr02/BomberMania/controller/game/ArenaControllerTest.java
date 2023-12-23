package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ArenaControllerTest {
    @Test
    void stepTest() throws IOException {
        Arena arena = Mockito.mock(Arena.class);
        ArenaController controller = new ArenaController(arena);

        Player1Controller player1 = Mockito.mock(Player1Controller.class);
        Player2Controller player2 = Mockito.mock(Player2Controller.class);
        BombController bomb = Mockito.mock(BombController.class);
        FlameController flame = Mockito.mock(FlameController.class);
        TimerController timer = Mockito.mock(TimerController.class);

        controller.setPlayer1(player1);
        controller.setPlayer2(player2);
        controller.setBomb(bomb);
        controller.setFlame(flame);
        controller.setTimer(timer);

        Game game = Mockito.mock(Game.class);

        Mockito.verify(player1, Mockito.times(0)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(player2, Mockito.times(0)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(bomb, Mockito.times(0)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(flame, Mockito.times(0)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(timer, Mockito.times(0)).step(game, GUI.ACTION.NONE, 1);
        controller.step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(player1, Mockito.times(1)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(player2, Mockito.times(1)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(bomb, Mockito.times(1)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(flame, Mockito.times(1)).step(game, GUI.ACTION.NONE, 1);
        Mockito.verify(timer, Mockito.times(1)).step(game, GUI.ACTION.NONE, 1);
    }
}
