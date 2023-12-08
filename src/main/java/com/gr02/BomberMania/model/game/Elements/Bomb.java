package com.gr02.BomberMania.model.game.Elements;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.BombInfo;
import com.gr02.BomberMania.model.game.Element;
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
            if (!propagating(arena, new Position(getPosition().getX() + i, getPosition().getY()))) break;
        }
        // Propagating Flame to the left
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (!propagating(arena, new Position(getPosition().getX() - i, getPosition().getY()))) break;
        }
        // Propagating Flame Down
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (!propagating(arena, new Position(getPosition().getX(), getPosition().getY() + i))) break;
        }
        // Propagating Flame Up
        for (int i = 0; i <= getBombInfo().getExplosionRadius(); i++) {
            if (!propagating(arena, new Position(getPosition().getX(), getPosition().getY() - i))) break;
        }
    }

    private boolean propagating(Arena arena, Position position) {
        if (arena.isNotIndestructible(position)) {
            arena.addFlame(new Flame(position.getX(), position.getY()));
            if (arena.destruct(position))
                return false;
        }
        else return false;

        return true;
    }
}
