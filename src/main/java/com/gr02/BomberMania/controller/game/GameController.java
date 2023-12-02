package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
