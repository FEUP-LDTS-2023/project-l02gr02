package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;

public class ArenaController extends GameController {
    private final Player1Controller player1;
    private final Player2Controller player2;
    private final BombController bomb;
    private final FlameController flame;

    private final TimerController timer;

    public ArenaController(Arena arena) {
        super(arena);

        this.player1 = new Player1Controller(arena);
        this.player2 = new Player2Controller(arena);
        this.bomb = new BombController(arena);
        this.flame = new FlameController(arena);
        this.timer = new TimerController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        player1.step(game, action, time);
        player2.step(game, action, time);
        bomb.step(game, action, time);
        flame.step(game, action, time);
        timer.step(game, action, time);

    }
}