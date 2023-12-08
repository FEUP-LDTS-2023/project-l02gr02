package com.gr02.BomberMania.states.game;


import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.controller.game.ArenaController;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
