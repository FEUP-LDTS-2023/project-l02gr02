package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Bomb;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.states.MenuState;

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
                getModel().getBombs().remove(bomb);
                bomb.explode(getModel());
                bomb.getBombInfo().getPlayer().increaseNumberOfBombs();
            }
        }
    }
}