package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Flame;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.states.menu.submenu.WinState;

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
            // Checking Player hits
            if (flame.checkHit(getModel(), getModel().getPlayer1())) {
                game.setState(new WinState(new WinMenu(2)));
            }
            if (flame.checkHit(getModel(), getModel().getPlayer2())) {
                game.setState(new WinState(new WinMenu(1)));
            }
            if (flame.getTimer() <= 0) {
                getModel().getFlames().remove(flame);
            }
        }
    }
}
