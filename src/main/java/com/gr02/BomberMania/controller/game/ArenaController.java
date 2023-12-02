package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        heroController.step(game, action, time);


    }
}