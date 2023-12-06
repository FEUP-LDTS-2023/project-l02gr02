package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.Bomb;
import com.gr02.BomberMania.model.game.BombInfo;
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

    protected void placeBomb(Position position, BombInfo info) {
        getModel().addBomb( new Bomb(position.getX(), position.getY(), info) );
    }
}
