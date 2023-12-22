package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Flame;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.states.menu.submenu.DrawState;
import com.gr02.BomberMania.states.menu.submenu.WinState;

import java.io.IOException;
import java.util.List;

public class FlameController extends GameController {

    public FlameController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        boolean player1Hit = false, player2Hit = false;
        // Flame timer
        List<Flame> flamesCopy = List.copyOf(getModel().getFlames());
        for (Flame flame : flamesCopy) {
            flame.reduceTimer();
            // Checking Player hits
            if (flame.checkHit(getModel().getPlayer1())) {
                player1Hit = true;
            }
            if (flame.checkHit(getModel().getPlayer2())) {
                player2Hit = true;
            }
            if (flame.getTimer() <= 0) {
                getModel().getFlames().remove(flame);
            }
        }

        if (player1Hit && player2Hit) game.setState(new DrawState(new DrawMenu("BOTH DIED!!")));
        else if (player1Hit) game.setState(new WinState(new WinMenu(2)));
        else if (player2Hit) game.setState(new WinState(new WinMenu(1)));
    }
}
