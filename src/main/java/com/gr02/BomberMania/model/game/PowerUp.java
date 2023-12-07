package com.gr02.BomberMania.model.game;

public abstract class PowerUp extends Element {
    public PowerUp(int x, int y) {
        super(x, y);
    }
    public abstract void execute(PlayableCharacter player);
}
