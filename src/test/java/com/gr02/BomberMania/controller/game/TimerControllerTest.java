package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Timer;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.states.menu.submenu.DrawState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimerControllerTest {
    @Test
    void stepTest() throws IOException {
        Arena arena = new Arena(10, 10);
        arena.setTimer(new Timer(0, 0, 3));
        assertEquals(3, arena.getTimer().getTimeRemaining());

        TimerController controller = new TimerController(arena);

        Game game = Mockito.mock(Game.class);
        controller.step(game, GUI.ACTION.UP, 1);
        assertEquals(2, arena.getTimer().getTimeRemaining());

        controller.step(game, GUI.ACTION.UP, 1);
        assertEquals(1, arena.getTimer().getTimeRemaining());

        controller.step(game, GUI.ACTION.UP, 1);
        assertEquals(0, arena.getTimer().getTimeRemaining());

        List<DrawState> states = new ArrayList<>();
        Mockito.doAnswer((i) -> {
            states.add((DrawState) i.getArguments()[0]);
            return null;
        }).when(game).setState(Mockito.any(State.class));
        controller.step(game, GUI.ACTION.UP, 1);
        assertEquals("TIME IS UP!", states.get(0).getModel().getDrawReason());
    }
}
