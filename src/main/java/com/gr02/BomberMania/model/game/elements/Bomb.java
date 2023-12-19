package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.viewer.game.BombViewer;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class Bomb extends Element implements DetonatorObserver, Timed {
    private BombInfo bombInfo;

    public Bomb(int x, int y, BombInfo bombInfo) {
        super(x, y);
        this.bombInfo = bombInfo;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }

    @Override
    public void reduceTimer() {
        bombInfo.reduceTimer();
    }

    @Override
    public void explode(Arena arena) {
        // Remove bomb from the board
        arena.getBombs().remove(this);
        Game.explosion.play();
        getBombInfo().getPlayer().removeObserver(this);

        // Propagate Explosion Flame
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

        // Add bomb to the player
        getBombInfo().getPlayer().increaseNumberOfBombs();
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

    public boolean push(Arena arena, Position position) {
        if (position.getX() > getPosition().getX() && arena.isEmpty(getPosition().getLeft())) {
            setPosition(getPosition().getLeft());
            return true;
        }
        if (position.getX() < getPosition().getX() && arena.isEmpty(getPosition().getRight())) {
            setPosition(getPosition().getRight());
            return true;
        }
        if (position.getY() > getPosition().getY() && arena.isEmpty(getPosition().getUp())) {
            setPosition(getPosition().getUp());
            return true;
        }
        if (position.getY() < getPosition().getY() && arena.isEmpty(getPosition().getDown())) {
            setPosition(getPosition().getDown());
            return true;
        }
        return false;
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new BombViewer();
    }
}
