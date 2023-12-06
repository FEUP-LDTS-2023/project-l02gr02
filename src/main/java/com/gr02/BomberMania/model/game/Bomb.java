package com.gr02.BomberMania.model.game;

import com.gr02.BomberMania.model.Position;
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
        // Propagating Flame to the right
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (arena.isNotIndestructible(new Position(getPosition().getX() + i, getPosition().getY())))
                arena.addFlame(new Flame(getPosition().getX() + i, getPosition().getY()));
            else break;
        }
        // Propagating Flame to the left
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (arena.isNotIndestructible(new Position(getPosition().getX() - i, getPosition().getY())))
                arena.addFlame(new Flame(getPosition().getX() - i, getPosition().getY()));
            else break;
        }
        // Propagating Flame Down
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (arena.isNotIndestructible(new Position(getPosition().getX(), getPosition().getY() + i)))
                arena.addFlame(new Flame(getPosition().getX(), getPosition().getY() + i));
            else break;
        }
        // Propagating Flame Up
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (arena.isNotIndestructible(new Position(getPosition().getX(), getPosition().getY() - i)))
                arena.addFlame(new Flame(getPosition().getX(), getPosition().getY() - i));
            else break;
        }
    }
}
