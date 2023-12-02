package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;

public class ArenaController extends GameController {
    private final Player1Controller Player1;
    private final Player2Controller Player2;

    public ArenaController(Arena arena) {
        super(arena);

        this.Player1 = new Player1Controller(arena);
        this.Player2 = new Player2Controller(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        Player1.step(game, action, time);
        Player2.step(game, action, time);

    }
}