package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.BrickWall;
import com.gr02.BomberMania.model.game.elements.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setPlayer1(createPlayer1());
        arena.setPlayer2(createPlayer2());
        arena.setIndestructibleWalls(createIndestructibleWalls());
        arena.setBrickWalls(createBrickWalls());
        return arena;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract PlayableCharacter createPlayer1();
    protected abstract PlayableCharacter createPlayer2();
    protected abstract List<IndestructibleWall> createIndestructibleWalls();
    protected abstract List<BrickWall> createBrickWalls();
}
