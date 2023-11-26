package com.gr02.BomberMania.model.game.elements;

public class Bomb extends Element {
    private BombInfo bombInfo;
    public Bomb(int x, int y, BombInfo bombInfo) {
        super(x, y);
        this.bombInfo = bombInfo;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }
}
