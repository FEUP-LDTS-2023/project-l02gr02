package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.util.List;

public class BombController extends GameController {

    public BombController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        // Bomb advance timer and explosion logic
        List<Bomb> bombsCopy = List.copyOf(getModel().getBombs());
        for (Bomb bomb : bombsCopy) {
            bomb.reduceTimer();
            if (bomb.getBombInfo().getTimer() <= 0) {
                bomb.explode(getModel());
            }
        }
    }
}