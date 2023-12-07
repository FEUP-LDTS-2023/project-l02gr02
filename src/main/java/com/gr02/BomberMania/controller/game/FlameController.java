package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Flame;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;
import java.util.List;

public class FlameController extends GameController {

    public FlameController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // Flame timer
        List<Flame> flamesCopy = List.copyOf(getModel().getFlames());
        for (Flame flame : flamesCopy) {
            flame.reduceTimer();
            if (flame.getTimer() <= 0) {
                getModel().getFlames().remove(flame);
            }
        }
    }
}
