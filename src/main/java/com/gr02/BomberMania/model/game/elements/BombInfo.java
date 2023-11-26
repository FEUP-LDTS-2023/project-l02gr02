package com.gr02.BomberMania.model.game.elements;

public class BombInfo {

    private int timer;
    private int explosionRadius;

    public BombInfo(int timer, int explosionRadius) {
        this.timer = timer;
        this.explosionRadius = explosionRadius;
    }

    public BombInfo() {
        this.timer = 5;
        this.explosionRadius = 3;
    }

    public int getTimer() {
        return timer;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }
}
