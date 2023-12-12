package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.states.menu.submenu.DrawState;

import java.io.IOException;

public class TimerController extends GameController {
    public TimerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (getModel().getTimer().getTimeRemaining() > 0) getModel().getTimer().reduceTimer();
        else game.setState(new DrawState(new DrawMenu()));
    }
}
