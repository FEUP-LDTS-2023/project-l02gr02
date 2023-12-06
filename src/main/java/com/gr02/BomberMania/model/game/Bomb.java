package com.gr02.BomberMania.model.game;

import com.gr02.BomberMania.model.game.arena.Arena;

public class Bomb extends Element {
    private BombInfo bombInfo;
    public Bomb(int x, int y, BombInfo bombInfo) {
        super(x, y);
        this.bombInfo = bombInfo;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }

    public void reduceTimer() {
        bombInfo.reduceTimer();
    }

    public void explode(Arena arena) {
        for (int i = -getBombInfo().getExplosionRadius(); i <= getBombInfo().getExplosionRadius(); i++) {
            arena.addFlame(new Flame(getPosition().getX() + i, getPosition().getY()));
            arena.addFlame(new Flame(getPosition().getX(), getPosition().getY() + i));
        }
    }
}
