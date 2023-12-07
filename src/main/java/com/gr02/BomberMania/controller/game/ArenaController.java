package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Bomb;
import com.gr02.BomberMania.model.game.Elements.Flame;
import com.gr02.BomberMania.model.game.arena.Arena;

import java.io.IOException;
import java.util.List;

public class ArenaController extends GameController {
    private final Player1Controller player1;
    private final Player2Controller player2;
    private final BombController bomb;
    private final FlameController flame;

    public ArenaController(Arena arena) {
        super(arena);

        this.player1 = new Player1Controller(arena);
        this.player2 = new Player2Controller(arena);
        this.bomb = new BombController(arena);
        this.flame = new FlameController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        player1.step(game, action, time);
        player2.step(game, action, time);
        bomb.step(game, action, time);
        flame.step(game, action, time);

    }
}