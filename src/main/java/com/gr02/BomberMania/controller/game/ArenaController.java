package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Bomb;
import com.gr02.BomberMania.model.game.Flame;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;
import java.util.List;

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

        // Bomb timer and explosion logic
        List<Bomb> bombsCopy = List.copyOf(getModel().getBombs());
        for (Bomb bomb : bombsCopy) {
            bomb.reduceTimer();
            if (bomb.getBombInfo().getTimer() <= 0) {
                getModel().getBombs().remove(bomb);
                bomb.explode(getModel());
                bomb.getBombInfo().getPlayer().increaseNumberOfBombs();
            }
        }

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