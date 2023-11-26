package com.gr02.BomberMania.model.game.elements;

public class BombInfo {

    public int timer;
    public int explosion_radius;

    public BombInfo(int timer, int explosion_radius) {
        this.timer = timer;
        this.explosion_radius = explosion_radius;
    }
}
