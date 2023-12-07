package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;


public abstract class PlayableCharacterController extends GameController {
    public PlayableCharacterController(Arena arena) {
        super(arena);
    }

    public abstract void moveHeroLeft();

    public abstract void moveHeroRight();

    public abstract void moveHeroUp();

    public abstract void moveHeroDown();

    protected abstract void moveHero(Position position);

    protected abstract void placeBomb();
}
